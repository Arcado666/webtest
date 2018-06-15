package com.webtest.utils;

public class ThreadUtil
{
  public static void silentSleep(long timeout)
  {
    try
    {
      Thread.sleep(timeout);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}