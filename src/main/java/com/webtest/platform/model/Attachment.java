package com.webtest.platform.model;

import java.util.Date;

/**
 * 附件表
 * @author 
 * @date 
 */
public class Attachment
{
	private String id;
	private String ownerId;
	private String belongId;
	private String configId;
	private String fileName;
	private String relativePath;
	private String remark;
	private Date createTime;
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
	 * @return the ownerId
	 */
	public String getOwnerId()
	{
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}
	/**
	 * @return the belongId
	 */
	public String getBelongId()
	{
		return belongId;
	}
	/**
	 * @param belongId the belongId to set
	 */
	public void setBelongId(String belongId)
	{
		this.belongId = belongId;
	}
	/**
	 * @return the configId
	 */
	public String getConfigId()
	{
		return configId;
	}
	/**
	 * @param configId the configId to set
	 */
	public void setConfigId(String configId)
	{
		this.configId = configId;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}
	/**
	 * @return the relativePath
	 */
	public String getRelativePath()
	{
		return relativePath;
	}
	/**
	 * @param relativePath the relativePath to set
	 */
	public void setRelativePath(String relativePath)
	{
		this.relativePath = relativePath;
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
	/**
	 * @return the createTime
	 */
	public Date getCreateTime()
	{
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
}
