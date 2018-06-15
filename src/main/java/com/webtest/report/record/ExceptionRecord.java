package com.webtest.report.record;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class ExceptionRecord
{
  private Throwable throwable;
  private NormalRecord normalRecord;
  private List<File> attachFileList;

  public ExceptionRecord(Throwable throwable)
  {
    this.throwable = throwable;
  }

  public ExceptionRecord(Throwable throwable, NormalRecord normalRecord)
  {
    this.throwable = throwable;
    this.normalRecord = normalRecord;
  }

  public Throwable getThrowable()
  {
    return this.throwable;
  }

  public void setThrowable(Throwable throwable)
  {
    this.throwable = throwable;
  }

  public String getStackTraceText()
  {
    if (this.throwable == null)
    {
      return "";
    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    this.throwable.printStackTrace(new PrintStream(out));
    return out.toString();
  }

  public NormalRecord getNormalRecord()
  {
    return this.normalRecord;
  }

  public void setNormalRecord(NormalRecord normalRecord)
  {
    this.normalRecord = normalRecord;
  }

  public List<File> getAttachFileList()
  {
    return this.attachFileList;
  }

  public void setAttachFileList(List<File> attachFileList)
  {
    this.attachFileList = attachFileList;
  }
}