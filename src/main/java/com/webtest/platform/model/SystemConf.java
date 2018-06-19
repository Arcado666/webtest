package com.webtest.platform.model;

/**
 * 系统配置
 * @author
 * @date
 */
public class SystemConf
{
	/** 动态图片的保存路径 */
	private String gifPath;
	/** 全局默认的密钥 */
	private String securtyKey;
	/** 附件所在根目录 */
	private String attachRoot;
	/** 谷歌浏览器版本号 */
	private String chromeVer;
	/** autoit3路径 */
	private String autoIt;
	/**
	 * @return the gifPath
	 */
	public String getGifPath()
	{
		return gifPath;
	}
	/**
	 * @param gifPath the gifPath to set
	 */
	public void setGifPath(String gifPath)
	{
		this.gifPath = gifPath;
	}
	/**
	 * @return the securtyKey
	 */
	public String getSecurtyKey()
	{
		return securtyKey;
	}
	/**
	 * @param securtyKey the securtyKey to set
	 */
	public void setSecurtyKey(String securtyKey)
	{
		this.securtyKey = securtyKey;
	}
	/**
	 * @return the attachRoot
	 */
	public String getAttachRoot()
	{
		return attachRoot;
	}
	/**
	 * @param attachRoot the attachRoot to set
	 */
	public void setAttachRoot(String attachRoot)
	{
		this.attachRoot = attachRoot;
	}
	/**
	 * @return the chromeVer
	 */
	public String getChromeVer()
	{
		return chromeVer;
	}
	/**
	 * @param chromeVer the chromeVer to set
	 */
	public void setChromeVer(String chromeVer)
	{
		this.chromeVer = chromeVer;
	}
	public String getAutoIt()
	{
		return autoIt;
	}
	public void setAutoIt(String autoIt)
	{
		this.autoIt = autoIt;
	}
}
