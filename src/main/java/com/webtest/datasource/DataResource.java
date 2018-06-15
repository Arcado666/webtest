package com.webtest.datasource;

import java.io.IOException;
import java.net.URL;

public abstract interface DataResource
{
  public abstract URL getUrl()
    throws IOException;
}
