package com.webtest.webui.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webtest.webui.util.PathUtil;

@Component
public class SuRenRandomFile
  implements RandomFile
{

  @Autowired
  private RandomFileContent randomContent;
  private String fileName = "suren.png";

  public File createFile()
  {
    File randomFile = null;
    try { InputStream content = this.randomContent.getContent(); Throwable localThrowable3 = null;
      try {
        randomFile = PathUtil.copyFileToRoot(content, this.fileName);
      }
      catch (Throwable localThrowable1)
      {
        localThrowable3 = localThrowable1; throw localThrowable1;
      }
      finally {
        if (content != null) if (localThrowable3 != null) try { content.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else content.close();  
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    return randomFile;
  }
}
