package com.webtest.webui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class PathUtil
{
  public static File getRootDir()
  {
    String rootDir = System.getProperty("user.home", ".");
    File rootFile = new File(rootDir, ".autotest");
    if (!rootFile.isDirectory())
    {
      rootFile.mkdirs();
    }

    return rootFile;
  }

  public static File copyFileToRoot(InputStream input, String fileName)
  {
    File rootFile = getRootDir();
    File targetFile = new File(rootFile, fileName);
    if (!targetFile.isFile())
    {
      copyFileToRoot(input, targetFile);
    }

    return targetFile;
  }

  public static boolean copyFileToRoot(InputStream input, File targetFile)
  {
    try
    {
      OutputStream output = new FileOutputStream(targetFile); 
      Throwable localThrowable3 = null;
      try {
        IOUtils.copy(input, output);

//        int i = 1;
//        return i;
      }
      catch (Throwable localThrowable4)
      {
        localThrowable3 = localThrowable4; throw localThrowable4;
      }
      finally
      {
        if (output != null) if (localThrowable3 != null) try { output.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else output.close();  
      }
    }
    catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return false;
  }
}