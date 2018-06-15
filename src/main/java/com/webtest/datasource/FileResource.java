package com.webtest.datasource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FileResource
  implements DataResource
{
  private File file;

  public FileResource(File file)
  {
    this.file = file;
  }

  public URL getUrl()
    throws MalformedURLException
  {
    return this.file.toURI().toURL();
  }
}
