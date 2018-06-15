package com.webtest.utils;

public class OSUtil
{
  public static boolean is64Bit()
  {
    String osArch = System.getenv("PROCESSOR_ARCHITECTURE");
    if (StringUtils.isNotBlank(osArch))
    {
      return osArch.contains("64");
    }

    return false;
  }
}
