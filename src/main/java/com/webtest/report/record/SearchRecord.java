package com.webtest.report.record;

import java.util.List;

public class SearchRecord
{
  private String strategy;
  private List<String> byList;
  private long cost;

  public SearchRecord(String strategy, long cost)
  {
    this.strategy = strategy;
    this.cost = cost;
  }

  public SearchRecord(long cost) {
    this.cost = cost;
  }

  public String getStrategy()
  {
    return this.strategy;
  }

  public void setStrategy(String strategy)
  {
    this.strategy = strategy;
  }

  public List<String> getByList()
  {
    return this.byList;
  }

  public void setByList(List<String> byList)
  {
    this.byList = byList;
  }

  public long getCost()
  {
    return this.cost;
  }

  public void setCost(long cost)
  {
    this.cost = cost;
  }
}
