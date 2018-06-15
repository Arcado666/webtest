package com.webtest.webui.core;

public abstract interface Locator
{
  public abstract String getType();

  public abstract String getValue();

  public abstract long getTimeout();
}
