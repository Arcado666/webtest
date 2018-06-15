package com.webtest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Properties;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;

public abstract class EncryptorUtil
{
  public static final String ENCRYPT_FILE = "encrypt.properties";
  public static final String ENCRYPT_KEY = "encrypt.key";

  public static String getSecretKey()
  {
    ClassLoader clsLoader = EncryptorUtil.class.getClassLoader();
    Enumeration urls = null;
    try
    {
      urls = clsLoader.getResources("encrypt.properties");
    }
    catch (IOException e1)
    {
      e1.printStackTrace();
    }

    if ((urls == null) || (!urls.hasMoreElements()))
    {
      throw new RuntimeException("Can not found encrypt.properties!");
    }
    try {
      InputStream input = ((URL)urls.nextElement()).openStream(); Throwable localThrowable3 = null;
      try {
        if (input == null)
        {
          throw new RuntimeException("Can not found encrypt.properties!");
        }

        Properties encryptPro = new Properties();
        encryptPro.load(input);

        if (!encryptPro.containsKey("encrypt.key"))
        {
          throw new RuntimeException("Can not found encrypt.key from encrypt.properties!");
        }

        String str = encryptPro.getProperty("encrypt.key");
        return str;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable3 = localThrowable1; throw localThrowable1;
      }
      finally
      {
        if (input != null) if (localThrowable3 != null) try { input.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else input.close();  
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return null;
  }

  public static String encrypt(String plainText)
  {
    try
    {
      return Encryptor.getInstance("DES", getSecretKey()).encryptStr(plainText);
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (BadPaddingException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }

    return plainText;
  }

  public static String decrypt(String encryptText)
  {
    try
    {
      return Encryptor.getInstance("DES", getSecretKey()).decryptStr(encryptText);
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (BadPaddingException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }

    return encryptText;
  }

  public static String encryptWithBase64(String plainText)
  {
    try
    {
      return Base64.encodeBase64String(Encryptor.getInstance("DES", getSecretKey()).encrypt(plainText));
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (BadPaddingException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }

    return null;
  }

  public static String decryptWithBase64(String base64Text)
  {
    byte[] encryptData = Base64.decodeBase64(base64Text);
    try
    {
      return Encryptor.getInstance("DES", getSecretKey()).decryptStr(encryptData);
    }
    catch (InvalidKeyException e)
    {
      e.printStackTrace();
    }
    catch (IllegalBlockSizeException e)
    {
      e.printStackTrace();
    }
    catch (BadPaddingException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchAlgorithmException e)
    {
      e.printStackTrace();
    }
    catch (NoSuchPaddingException e)
    {
      e.printStackTrace();
    }

    return base64Text;
  }
}