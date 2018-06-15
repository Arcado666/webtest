package com.webtest.datasource;

import java.util.Map;

public abstract interface DynamicDataSource
{
  public abstract void setGlobalMap(Map<String, Object> paramMap);

  public abstract Map<String, Object> getGlobalMap();

  public abstract String getName();
}