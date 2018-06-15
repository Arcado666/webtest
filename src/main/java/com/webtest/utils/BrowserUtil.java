package com.webtest.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BrowserUtil
{
  private Map<String, Boolean> preBoolMap;
  private Map<String, String> preStrMap;
  private Map<String, Integer> preIntMap;

  public Map<String, Boolean> getFirefoxPreBoolMap()
  {
    this.preBoolMap = new HashMap();
    Properties properties = System.getProperties();
    Iterator keyIt = properties.keySet().iterator();
    while (keyIt.hasNext())
    {
      Object key = keyIt.next();
      String keyStr = key.toString();

      if (keyStr.indexOf("firefox.bool.") != -1)
      {
        this.preBoolMap.put(keyStr.substring("firefox.bool.".length()), 
          Boolean.valueOf(Boolean.parseBoolean(properties
          .getProperty(keyStr, "false"))));
      }

    }

    return this.preBoolMap;
  }

  public Map<String, String> getFirefoxPreStrMap()
  {
    this.preStrMap = new HashMap();
    Properties properties = System.getProperties();
    Iterator keyIt = properties.keySet().iterator();
    while (keyIt.hasNext())
    {
      Object key = keyIt.next();
      String keyStr = key.toString();

      if (keyStr.indexOf("firefox.string.") != -1)
      {
        this.preStrMap.put(keyStr.substring("firefox.string.".length()), properties
          .getProperty(keyStr));
      }

    }

    return this.preStrMap;
  }

  public Map<String, Integer> getFirefoxPreIntMap()
  {
    this.preIntMap = new HashMap();
    Properties properties = System.getProperties();
    Iterator keyIt = properties.keySet().iterator();
    while (keyIt.hasNext())
    {
      Object key = keyIt.next();
      String keyStr = key.toString();

      if (keyStr.indexOf("firefox.int.") != -1)
      {
        this.preIntMap.put(keyStr.substring("firefox.int.".length()), 
          Integer.valueOf(Integer.parseInt(properties
          .getProperty(keyStr, "0"))));
      }

    }

    return this.preIntMap;
  }
}
