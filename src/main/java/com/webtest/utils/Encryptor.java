package com.webtest.utils;

import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class Encryptor
{
  private SecretKey key;
  private Cipher cipher;
  private byte[] cipherByte;
  public static final String ALG_DES = "DES";
  private static Encryptor encryptor;

  private Encryptor()
  {
  }

  private Encryptor(String algorithm, String keyStr)
    throws NoSuchAlgorithmException, NoSuchPaddingException
  {
    this.key = getSecretKey(keyStr, "DES");

    this.cipher = Cipher.getInstance(algorithm);
  }

  public static Encryptor getInstance(String algorithm, String secretKey) throws NoSuchAlgorithmException, NoSuchPaddingException
  {
    if (encryptor == null)
    {
      if (StringUtils.isBlank(secretKey))
      {
        secretKey = "http://surenpi.com";
      }

      encryptor = new Encryptor(algorithm, secretKey);
    }

    return encryptor;
  }

  public byte[] encrypt(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
  {
    this.cipher.init(1, this.key);
    this.cipherByte = this.cipher.doFinal(str.getBytes());
    return this.cipherByte;
  }

  public String encryptStr(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
  {
    byte[] encryptArray = encrypt(str);

    StringBuffer strBuf = new StringBuffer();
    for (byte e : encryptArray)
    {
      strBuf.append(intToChar(e >> 4 & 0xF));
      strBuf.append(intToChar(e & 0xF));
    }

    return strBuf.toString();
  }

  public byte[] decrypt(byte[] buf) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
  {
    this.cipher.init(2, this.key);
    this.cipherByte = this.cipher.doFinal(buf);
    return this.cipherByte;
  }

  public String decryptStr(byte[] buf) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
  {
    return new String(decrypt(buf));
  }

  public String decryptStr(String encryptStr)
    throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException
  {
    if (encryptStr == null)
    {
      throw new NullPointerException();
    }

    encryptStr = encryptStr.toUpperCase();

    ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
    int len = encryptStr.length();
    for (int i = 0; i < len; i += 2)
    {
      int b = charToByte(encryptStr.charAt(i)) << 4 & 0xFF | charToByte(encryptStr.charAt(i + 1));
      byteOut.write(b);
    }

    return decryptStr(byteOut.toByteArray());
  }

  private byte charToByte(char c)
  {
    return (byte)"0123456789ABCDEF".indexOf(c);
  }

  private char intToChar(int b)
  {
    return "0123456789ABCDEF".charAt(b);
  }

  public void clean()
  {
    this.cipherByte = null;
  }

  public static SecretKey getSecretKey(String desKey, String algorithm)
  {
    if (StringUtils.isBlank(desKey))
    {
      throw new IllegalArgumentException("密钥不能为空。");
    }
    return getSecretKey(Base64.decodeBase64(desKey), algorithm);
  }

  public static SecretKey getSecretKey(byte[] desKey, String algorithm)
  {
    if ("DES".equalsIgnoreCase(algorithm))
    {
      try
      {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(algorithm);
        DESKeySpec dks = new DESKeySpec(desKey);
        return keyFactory.generateSecret(dks);
      }
      catch (NoSuchAlgorithmException e)
      {
        throw new RuntimeException(e.getCause());
      }
      catch (Exception e)
      {
        throw new IllegalArgumentException("将密钥字符串转换为密钥实例对象失败。", e);
      }
    }

    return new SecretKeySpec(desKey, algorithm);
  }
}
