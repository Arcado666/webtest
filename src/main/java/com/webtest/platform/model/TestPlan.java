package com.webtest.platform.model;

import java.util.Date;

/**
 * 测试计划
 * @author suren
 * @date 2017年3月1日 下午6:09:41
 */
public class TestPlan
{
	private String id;
	private String name;
	private String ownerId;
	private String suiteRunnerId;
	private String cronExp;
	private Date createTime;
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
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	public String getOwnerId()
	{
		return ownerId;
	}
	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}
	/**
	 * @return the suiteRunnerId
	 */
	public String getSuiteRunnerId()
	{
		return suiteRunnerId;
	}
	/**
	 * @param suiteRunnerId the suiteRunnerId to set
	 */
	public void setSuiteRunnerId(String suiteRunnerId)
	{
		this.suiteRunnerId = suiteRunnerId;
	}
	/**
	 * @return the cronExp
	 */
	public String getCronExp()
	{
		return cronExp;
	}
	/**
	 * @param cronExp the cronExp to set
	 */
	public void setCronExp(String cronExp)
	{
		this.cronExp = cronExp;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
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
