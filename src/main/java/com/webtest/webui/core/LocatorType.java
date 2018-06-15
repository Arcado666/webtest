package com.webtest.webui.core;

public enum LocatorType
{
  BY_ID("byId"), 

  BY_NAME("byName"), 
  BY_XPATH("byXpath"), 

  BY_TAGNAME("byTagName"), 
  BY_CSS("byCss"), 
  BY_LINK_TEXT("byLinkText"), 
  BY_PARTIAL_LINK_TEXT("byPartialLinkText"), 

  BY_FRAME_INDEX("byIFrameIndex"), 

  BY_FRAME_NAME("byIFrame");

  private String name;

  private LocatorType(String name) {
    this.name = name;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
