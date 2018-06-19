package com.webtest.code.model;

public class AutoField
{
  private String name;
  private String type;
  private String comment;
  private String getterMethod;
  private String setterMethod;

  public AutoField(String name, String type)
  {
    this.name = name;
    this.type = type;
  }

  public AutoField(String name, String type, String comment) {
    this.name = name;
    this.type = type;
    this.comment = comment;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getType()
  {
    return this.type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getGetterMethod()
  {
    return this.getterMethod;
  }

  public void setGetterMethod(String getterMethod)
  {
    this.getterMethod = getterMethod;
  }

  public String getSetterMethod()
  {
    return this.setterMethod;
  }

  public void setSetterMethod(String setterMethod)
  {
    this.setterMethod = setterMethod;
  }

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
