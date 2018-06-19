package com.webtest.platform.model;

import java.util.Date;

/**
 * 用户行为
 * @author 
 * @date
 */
public class UserBehavior
{
	private String id;
	private String userId;
	private String method;
	private String userAgent;
	private String serverIP;
	private String clientIP;
	private String operatingSystem;
	private String requestUri;
	private String queryInfo;
	private String cookie;
	private Date visitTime;
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
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	/**
	 * @return the method
	 */
	public String getMethod()
	{
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method)
	{
		this.method = method;
	}
	/**
	 * @return the userAgent
	 */
	public String getUserAgent()
	{
		return userAgent;
	}
	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}
	/**
	 * @return the serverIP
	 */
	public String getServerIP()
	{
		return serverIP;
	}
	/**
	 * @param serverIP the serverIP to set
	 */
	public void setServerIP(String serverIP)
	{
		this.serverIP = serverIP;
	}
	/**
	 * @return the clientIP
	 */
	public String getClientIP()
	{
		return clientIP;
	}
	/**
	 * @param clientIP the clientIP to set
	 */
	public void setClientIP(String clientIP)
	{
		this.clientIP = clientIP;
	}
	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem()
	{
		return operatingSystem;
	}
	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem)
	{
		this.operatingSystem = operatingSystem;
	}
	/**
	 * @return the requestUri
	 */
	public String getRequestUri()
	{
		return requestUri;
	}
	/**
	 * @param requestUri the requestUri to set
	 */
	public void setRequestUri(String requestUri)
	{
		this.requestUri = requestUri;
	}
	public String getQueryInfo()
	{
		return queryInfo;
	}
	public void setQueryInfo(String queryInfo)
	{
		this.queryInfo = queryInfo;
	}
	/**
	 * @return the cookie
	 */
	public String getCookie()
	{
		return cookie;
	}
	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(String cookie)
	{
		this.cookie = cookie;
	}
	/**
	 * @return the visitTime
	 */
	public Date getVisitTime()
	{
		return visitTime;
	}
	/**
	 * @param visitTime the visitTime to set
	 */
	public void setVisitTime(Date visitTime)
	{
		this.visitTime = visitTime;
	}
}
