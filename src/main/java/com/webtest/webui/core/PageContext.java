package com.webtest.webui.core;

import java.util.Map;

import com.webtest.webui.Page;

public class PageContext
{
  private Map<String, Page> pageMap;

  public PageContext()
  {
  }

  public PageContext(Map<String, Page> pageMap)
  {
    this.pageMap = pageMap;
  }

  public Map<String, Page> getPageMap()
  {
    return this.pageMap;
  }

  public void setPageMap(Map<String, Page> pageMap)
  {
    this.pageMap = pageMap;
  }
}
