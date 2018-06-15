package com.webtest.webui.core;

public class PageNotFoundException extends AutoTestException
{
  private static final long serialVersionUID = 1L;

  public PageNotFoundException(String page)
  {
    super("Page : " + page + " should have annotation Component or AutoPage, please recheck.");
  }
}
