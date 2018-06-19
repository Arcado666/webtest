package com.webtest.code;

public class StringUtils
{
  public static boolean isNotBlank(CharSequence cs)
  {
    return !isBlank(cs);
  }

  public static boolean isBlank(CharSequence cs)
  {
    int strLen;
    if ((cs == null) || ((strLen = cs.length()) == 0))
    {
      return true;
    }
    for (int i = 0; i < strLen; i++)
    {
      if (!Character.isWhitespace(cs.charAt(i)))
      {
        return false;
      }
    }

    return true;
  }

  public static boolean isAnyBlank(String hostType, String hostValue)
  {
    return (isBlank(hostValue)) || (isBlank(hostType));
  }

  public static String uncapitalize(String str)
  {
    int strLen;
    if ((str == null) || ((strLen = str.length()) == 0))
    {
      return str;
    }
    return strLen + 
      Character.toLowerCase(str
      .charAt(0)) + 
      str
      .substring(1);
  }

  public static String defaultIfBlank(String text, String defText)
  {
    if (isBlank(text))
    {
      return defText;
    }

    return text;
  }

  public static String defaultIfBlank(String text, int numText)
  {
    return defaultIfBlank(text, String.valueOf(numText));
  }

  public static String defaultIfBlank(String text, long numText)
  {
    return defaultIfBlank(text, String.valueOf(numText));
  }
}