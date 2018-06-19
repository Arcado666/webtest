package com.webtest.platform.model;

import java.util.Date;

/**
 * @author
 * @date
 */
public class SuiteRunnerLog
{
	private String id;
	private String suiteRunnerInfoId;
	private String triggerUserId;
	private String message;
	private Date beginTime;
	private Date endTime;
	private String remark;
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * @return the suiteRunnerInfoId
	 */
	public String getSuiteRunnerInfoId()
	{
		return suiteRunnerInfoId;
	}
	/**
	 * @param suiteRunnerInfoId the suiteRunnerInfoId to set
	 */
	public void setSuiteRunnerInfoId(String suiteRunnerInfoId)
	{
		this.suiteRunnerInfoId = suiteRunnerInfoId;
	}
	/**
	 * @return the triggerUserId
	 */
	public String getTriggerUserId()
	{
		return triggerUserId;
	}
	/**
	 * @param triggerUserId the triggerUserId to set
	 */
	public void setTriggerUserId(String triggerUserId)
	{
		this.triggerUserId = triggerUserId;
	}
	/**
	 * @return the message
	 */
	public String getMessage()
	{
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message)
	{
		this.message = message;
	}
	/**
	 * @return the beginTime
	 */
	public Date getBeginTime()
	{
		return beginTime;
	}
	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(Date beginTime)
	{
		this.beginTime = beginTime;
	}
	/**
	 * @return the endTime
	 */
	public Date getEndTime()
	{
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	/**
	 * @return the remark
	 */
	public String getRemark()
	{
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark)
	{
		this.remark = remark;
	}
}
