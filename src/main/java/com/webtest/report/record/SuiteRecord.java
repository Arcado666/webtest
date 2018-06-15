package com.webtest.report.record;

import java.util.List;

public class SuiteRecord
{
  private List<ActionRecord> actionRecordList;
  private List<SearchRecord> searchRecordList;

  public List<ActionRecord> getActionRecordList()
  {
    return this.actionRecordList;
  }

  public void setActionRecordList(List<ActionRecord> actionRecordList)
  {
    this.actionRecordList = actionRecordList;
  }

  public List<SearchRecord> getSearchRecordList()
  {
    return this.searchRecordList;
  }

  public void setSearchRecordList(List<SearchRecord> searchRecordList)
  {
    this.searchRecordList = searchRecordList;
  }
}
