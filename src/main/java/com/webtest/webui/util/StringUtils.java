package com.webtest.webui.util;

import java.util.Iterator;
import java.util.Map;

public class StringUtils
{
  @SuppressWarnings("rawtypes")
public static String paramTranslate(Map<String, Object> data, String paramPrefix, String value)
  {
    String result = value;

    Iterator dataIt = data.keySet().iterator();
    while (dataIt.hasNext())
    {
      String param = (String)dataIt.next();
      if (!param.startsWith(paramPrefix))
      {
        continue;
      }

      Object paramVal = data.get(param);
      if (paramVal != null)
      {
        result = result.replace("${" + param + "}", paramVal.toString());
      }
    }

    return result;
  }

  public static String email(String server)
  {
    StringBuffer buf = new StringBuffer();

    buf.append(RandomStringUtils.randomAlphabetic(3));
    buf.append("@");
    buf.append(server);

    return buf.toString();
  }

  public static String email(int namesize, int servernamesize)
  {
    String name = RandomStringUtils.randomAlphabetic(randomtest(servernamesize));

    String[] sa = new String[3];
    sa[0] = "com";
    sa[1] = "cn";
    sa[2] = "net";

    StringBuffer buf = new StringBuffer();
    String server = name + "." + sa[randomtest(sa.length)];

    buf.append(RandomStringUtils.randomAlphabetic(randomtest(namesize)));
    buf.append("@");
    buf.append(server);

    return buf.toString();
  }

  public static String email()
  {
    String name = RandomStringUtils.randomAlphabetic(randomtest(10));

    String[] sa = new String[3];
    sa[0] = "com";
    sa[1] = "cn";
    sa[2] = "net";
    StringBuffer buf = new StringBuffer();
    String server = name + "." + sa[randomtest(sa.length)];

    buf.append(RandomStringUtils.randomAlphabetic(randomtest(10)));
    buf.append("@");
    buf.append(server);

    return buf.toString();
  }

  public static int randomtest(int max)
  {
    int x = 0;

    if (max > 0)
    {
      x = (int)(Math.random() * max);
      return x;
    }

    return 0;
  }

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
