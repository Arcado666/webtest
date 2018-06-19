package com.webtest.code.model;

import java.util.List;

public class AutoPage
{
  private String comment;
  private String packageName;
  private String name;
  private List<AutoField> fields;

  public String getComment()
  {
    return this.comment;
  }

  public void setComment(String comment)
  {
    this.comment = comment;
  }

  public String getPackageName()
  {
    return this.packageName;
  }

  public void setPackageName(String packageName)
  {
    this.packageName = packageName;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<AutoField> getFields()
  {
    return this.fields;
  }

  public void setFields(List<AutoField> fields)
  {
    this.fields = fields;
  }
}