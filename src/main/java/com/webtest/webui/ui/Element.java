package com.webtest.webui.ui;

import java.util.List;

import com.webtest.webui.core.Locator;

public abstract interface Element
{
  public abstract String getId();

  public abstract String getName();

  public abstract String getTagName();

  public abstract String getCSS();

  public abstract String getXPath();

  public abstract String getLinkText();

  public abstract String getPartialLinkText();

  public abstract List<Locator> getLocatorList();

  public abstract String getStrategy();

  public abstract long getTimeOut();

  public abstract int getIndex();
}
