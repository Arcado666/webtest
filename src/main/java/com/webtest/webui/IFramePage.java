package com.webtest.webui;

public abstract class IFramePage extends Page
{
  private String frameId;

  public String getFrameId()
  {
    return this.frameId;
  }

  public void setFrameId(String frameId)
  {
    this.frameId = frameId;
  }
}
