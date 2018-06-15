package com.webtest.webui.core;

public abstract interface WebUIEngine
{
  public abstract <T> T getPage(Class<T> paramClass);

  public abstract <T> T getModule(Class<T> paramClass);

  public abstract void open(String paramString);

  public abstract <T> T getDriver();
}
