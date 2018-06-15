package com.webtest.report;

import com.webtest.report.record.ExceptionRecord;
import com.webtest.report.record.NormalRecord;
import com.webtest.report.record.ProjectRecord;

public abstract interface RecordReportWriter
{
  public abstract void write(ExceptionRecord paramExceptionRecord);

  public abstract void write(NormalRecord paramNormalRecord);

  public abstract void write(ProjectRecord paramProjectRecord);
}