package com.webtest.datasource;


import java.util.Map;

public class DataSourceContext
{
  private Map<String, DataSource> dataSourceMap;

  public Map<String, DataSource> getDataSourceMap()
  {
    return this.dataSourceMap;
  }

  public void setDataSourceMap(Map<String, DataSource> dataSourceMap)
  {
    this.dataSourceMap = dataSourceMap;
  }
}
