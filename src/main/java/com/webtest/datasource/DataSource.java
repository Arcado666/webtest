package com.webtest.datasource;

public abstract interface DataSource<T> extends DynamicDataSource
{
  public abstract boolean loadData(DataResource paramDataResource, T paramT);

  public abstract boolean loadData(DataResource paramDataResource, int paramInt, T paramT);
}