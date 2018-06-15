package com.webtest.webui.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.stereotype.Component;

@Component
public class SuRenRandomFileContent
  implements RandomFileContent
{
  public InputStream getContent()
  {
    return new ByteArrayInputStream("AutoTest random file.".getBytes());
  }
}
