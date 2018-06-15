package com.webtest.webui.core;

public enum StrategyType
{
  PRIORITY("priority"), 

  CYLE("cyle"), 

  ZONE("zone");

  private String name;

  private StrategyType(String name) {
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
