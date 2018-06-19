package com.webtest.platform.model;

/**
 * @author 
 * @date 
 */
public class DebugRunInfo
{
	private String id;
	private int normalTimes;
	private int retryTimes;
	private int concurrentTimes;
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
	 * @return the normalTimes
	 */
	public int getNormalTimes()
	{
		return normalTimes;
	}
	/**
	 * @param normalTimes the normalTimes to set
	 */
	public void setNormalTimes(int normalTimes)
	{
		this.normalTimes = normalTimes;
	}
	/**
	 * @return the retryTimes
	 */
	public int getRetryTimes()
	{
		return retryTimes;
	}
	/**
	 * @param retryTimes the retryTimes to set
	 */
	public void setRetryTimes(int retryTimes)
	{
		this.retryTimes = retryTimes;
	}
	public int getConcurrentTimes()
	{
		return concurrentTimes;
	}
	public void setConcurrentTimes(int concurrentTimes)
	{
		this.concurrentTimes = concurrentTimes;
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
