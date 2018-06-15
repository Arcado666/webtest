package com.webtest.webui.core;

import java.util.Map;

import com.webtest.webui.ui.AbstractElement;


public class LocatorUtil
{
  public static void setLocator(Map<String, String> locatorMap, AbstractElement absEle)
  {
    for (String key : locatorMap.keySet())
    {
      String value = (String)locatorMap.get(key);

      switch (key)
      {
      case "byId":
        absEle.setId(value);
        break;
      case "byName":
        absEle.setName(value);
        break;
      case "byCss":
        absEle.setCSS(value);
        break;
      case "byXpath":
        absEle.setXPath(value);
        break;
      case "byLinkText":
        absEle.setLinkText(value);
        break;
      case "byPartialLinkText":
        absEle.setPartialLinkText(value);
        break;
      case "strategy":
        absEle.setStrategy(value);
      }
    }
  }
}