package com.webtest.datasource;

import java.util.Map;

public abstract interface DynamicData
{
  public abstract String getValue(String paramString);

  public abstract String getType();

  public abstract void setData(Map<String, Object> paramMap);
}
