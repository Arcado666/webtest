package com.webtest.report.record;

public class NormalRecord extends Record
{
  private String moduleName;
  private String moduleDescription;
  private String clazzName;
  private String methodName;

  public String getModuleName()
  {
    return this.moduleName;
  }

  public void setModuleName(String moduleName)
  {
    this.moduleName = moduleName;
  }

  public String getModuleDescription()
  {
    return this.moduleDescription;
  }

  public void setModuleDescription(String moduleDescription)
  {
    this.moduleDescription = moduleDescription;
  }

  public String getClazzName()
  {
    return this.clazzName;
  }

  public void setClazzName(String clazzName)
  {
    this.clazzName = clazzName;
  }

  public String getMethodName()
  {
    return this.methodName;
  }

  public void setMethodName(String methodName)
  {
    this.methodName = methodName;
  }
}
