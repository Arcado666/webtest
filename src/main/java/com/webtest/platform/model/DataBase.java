package com.webtest.platform.model;

/**
 * @author 
 * @date 
 */
public class DataBase
{
	private String driver;
	private String url;
	private int port;
	private String username;
	private String password;
	private String defaultSchema;
	private String schema;
	public String getDriver()
	{
		return driver;
	}
	public void setDriver(String driver)
	{
		this.driver = driver;
	}
	/**
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	/**
	 * @return the port
	 */
	public int getPort()
	{
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(int port)
	{
		this.port = port;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getDefaultSchema()
	{
		return defaultSchema;
	}
	public void setDefaultSchema(String defaultSchema)
	{
		this.defaultSchema = defaultSchema;
	}
	/**
	 * @return the schema
	 */
	public String getSchema()
	{
		return schema;
	}
	/**
	 * @param schema the schema to set
	 */
	public void setSchema(String schema)
	{
		this.schema = schema;
	}
}
