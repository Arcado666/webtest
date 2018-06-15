package com.webtest.report.record;

import java.util.List;
import java.util.Map;

public class ProjectRecord
{
  private String name;
  private String description;
  private String osName;
  private String osArch;
  private String osVersion;
  private String country;
  private String language;
  private String timezone;
  private String browserInfo;
  private String addressInfo;
  private Map<String, String> userInfo;
  private List<SuiteRecord> suiteRecordList;

  public String getName()
  {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOsName() {
    return this.osName;
  }

  public void setOsName(String osName) {
    this.osName = osName;
  }

  public String getOsArch() {
    return this.osArch;
  }

  public void setOsArch(String osArch) {
    this.osArch = osArch;
  }

  public String getOsVersion() {
    return this.osVersion;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getTimezone() {
    return this.timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getBrowserInfo()
  {
    return this.browserInfo;
  }

  public void setBrowserInfo(String browserInfo)
  {
    this.browserInfo = browserInfo;
  }

  public String getAddressInfo()
  {
    return this.addressInfo;
  }

  public void setAddressInfo(String addressInfo)
  {
    this.addressInfo = addressInfo;
  }

  public Map<String, String> getUserInfo()
  {
    return this.userInfo;
  }

  public void setUserInfo(Map<String, String> userInfo)
  {
    this.userInfo = userInfo;
  }

  public List<SuiteRecord> getSuiteRecordList()
  {
    return this.suiteRecordList;
  }

  public void setSuiteRecordList(List<SuiteRecord> suiteRecordList)
  {
    this.suiteRecordList = suiteRecordList;
  }
}
