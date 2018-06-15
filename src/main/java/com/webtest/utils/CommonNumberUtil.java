package com.webtest.utils;


public class CommonNumberUtil
{
  public static String postCode()
  {
    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < 6; i++)
    {
      buf.append(RandomUtils.nextInt(0, 10));
    }

    return buf.toString();
  }

  public static String phoneNumber()
  {
    StringBuffer buf = new StringBuffer();
    buf.append("182");

    for (int i = 0; i < 8; i++)
    {
      buf.append(RandomUtils.nextInt(0, 10));
    }

    return buf.toString();
  }
}
