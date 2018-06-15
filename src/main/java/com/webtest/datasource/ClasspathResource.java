package com.webtest.datasource;

import java.io.IOException;
import java.net.URL;

public class ClasspathResource
  implements DataResource
{
  private Class<?> clz;
  private String resourceName;

  public ClasspathResource(Class<?> clz, String resourceName)
  {
    this.clz = clz;
    this.resourceName = resourceName;
  }

  public URL getUrl()
    throws IOException
  {
    URL resUrl = this.clz.getClassLoader().getResource(this.resourceName);
    return resUrl;
  }
}
