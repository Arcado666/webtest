package com.webtest.webui.core;

public abstract interface ProgressInfo<T>
{
  public static final int ST_START = 1;
  public static final int ST_PROGRESS = 2;
  public static final int ST_NORMAL_END = 3;
  public static final int ST_ERROR_END = 4;

  public abstract void setInfo(T paramT);

  public abstract void setIdentify(String paramString);

  public abstract String getIdentify();

  public abstract void setStatus(int paramInt);
}
