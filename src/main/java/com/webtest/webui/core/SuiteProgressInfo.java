package com.webtest.webui.core;

public class SuiteProgressInfo
implements ProgressInfo<String>
{
private String msg;
private int status;
private String identify;

public void setInfo(String data)
{
  this.msg = data;
}

public void setIdentify(String id)
{
  this.identify = id;
}

public void setStatus(int status)
{
  this.status = status;
}

public String getMsg()
{
  return this.msg;
}

public int getStatus()
{
  return this.status;
}

public String getIdentify()
{
  return this.identify;
}
}
