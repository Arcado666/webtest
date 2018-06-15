package com.webtest.webui.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.webtest.webui.core.Locator;
import com.webtest.webui.util.StringUtils;

public abstract class AbstractElement implements Element
{
  private String id;
  private String name;
  private String tagName;
  private String CSS;
  private String XPath;
  private String linkText;
  private String partialLinkText;
  private List<Locator> locatorList = new ArrayList();
  private String strategy;
  private Map<String, Object> data = new HashMap();
  private String paramPrefix;
  private long timeOut;
  private int index;

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getTagName()
  {
    return this.tagName;
  }

  public void setTagName(String tagName)
  {
    this.tagName = tagName;
  }

  public String getCSS()
  {
    return this.CSS;
  }

  public void setCSS(String cSS)
  {
    this.CSS = cSS;
  }

  public String getXPath()
  {
    return this.XPath;
  }

  public void setXPath(String xPath)
  {
    this.XPath = xPath;
  }

  public String getLinkText()
  {
    return this.linkText;
  }

  public void setLinkText(String linkText)
  {
    this.linkText = linkText;
  }

  public String getPartialLinkText()
  {
    return this.partialLinkText;
  }

  public void setPartialLinkText(String partialLinkText)
  {
    this.partialLinkText = partialLinkText;
  }

  public List<Locator> getLocatorList()
  {
    return this.locatorList;
  }

  public void setLocatorList(List<Locator> locatorList)
  {
    this.locatorList = locatorList;
  }

  public String getStrategy()
  {
    return this.strategy;
  }

  public void setStrategy(String strategy)
  {
    this.strategy = strategy;
  }

  public void putData(String key, Object value)
  {
    this.data.put(key, value);
  }

  public void removeData(String key)
  {
    this.data.remove(key);
  }

  public boolean containsKey(String key)
  {
    return this.data.containsKey(key);
  }

  public void clearData()
  {
    this.data.clear();
  }

  public Object getData(String key)
  {
    return this.data.get(key);
  }

  public String getDataStr(String key)
  {
    Object dataObj = this.data.get(key);
    if (dataObj == null)
    {
      return "";
    }

    return dataObj.toString();
  }

  public abstract boolean isEnabled();

  public abstract boolean isHidden();

  public String paramTranslate(String value)
  {
    String result = value;
    result = StringUtils.paramTranslate(this.data, getParamPrefix(), result);

    return result;
  }

  public String getParamPrefix()
  {
    return this.paramPrefix;
  }

  public void setParamPrefix(String paramPrefix)
  {
    this.paramPrefix = paramPrefix;
  }

  public long getTimeOut()
  {
    return this.timeOut;
  }

  public void setTimeOut(long timeOut)
  {
    this.timeOut = timeOut;
  }

  public int getIndex()
  {
    return this.index;
  }

  public void setIndex(int index)
  {
    this.index = index;
  }
}