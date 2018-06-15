package com.webtest.report.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtils
{
  public static final String DEF_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
  public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  public static final String getDateText(long time)
  {
    return format.format(new Date(time));
  }
}
