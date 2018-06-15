package com.webtest.datasource;

import java.util.Set;

public abstract interface DynamicDateFormat
{
  public abstract Set<String> allFormats();

  public abstract boolean addFormat(String paramString);
}
