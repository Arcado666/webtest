
package com.webtest.platform.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.webtest.platform.schemas.autotest.Autotest;
import com.webtest.platform.schemas.autotest.PageType;
import com.webtest.platform.schemas.datasource.DataSourcePageFieldType;
import com.webtest.platform.schemas.datasource.DataSourcePageType;
import com.webtest.platform.schemas.datasource.DataSources;
import com.webtest.platform.schemas.datasource.DataSources.DataSource;
import com.webtest.platform.schemas.datasource.DataTypeEnum;
import com.webtest.platform.schemas.suite.Suite;
import com.webtest.platform.schemas.suite.SuitePageType;



/**
 * @author 
 * @date 
 */
public abstract class JAXBUtils
{
	/**
	 * 清空含有加密的数据
	 * @param dataSources
	 */
	public static void clearEncryptData(DataSources dataSources)
	{
		if(dataSources == null || dataSources.getDataSource() == null)
		{
			return;
		}
		
		for(DataSource dataSource : dataSources.getDataSource())
		{
			if(dataSource == null || dataSource.getPage() == null)
			{
				continue;
			}
			
			for(DataSourcePageType page : dataSource.getPage())
			{
				if(page == null || page.getField() == null)
				{
					continue;
				}
				
				for(DataSourcePageFieldType field : page.getField())
				{
					if(field.getType() == DataTypeEnum.ENCRYPT)
					{
						field.setData("");
					}
				}
			}
		}
	}
	
	/**
	 * 把类上含有包名的设置到包配置
	 * @param dataSources
	 */
	public static void packageTransfer(DataSources dataSources)
	{
		List<DataSource> dataSourcesList = dataSources.getDataSource();
		for(DataSource dataSource : dataSourcesList)
		{
			String clazz = dataSource.getPageClass();
			int index = clazz.lastIndexOf(".");
			if(index > 0)
			{
				String pkg = clazz.substring(0, index);
				String name = clazz.substring(index + 1);
				
				dataSources.setPagePackage(pkg);
				dataSource.setPageClass(name);
			}
		}
	}
	
	/**
	 * 对数据源进行处理
	 * @param dataSources
	 */
	public static void dataSourcesTransfer(DataSources dataSources)
	{
		JAXBUtils.clearEncryptData(dataSources);
		JAXBUtils.packageTransfer(dataSources);
	}
	
	/**
	 * 元素定位进行处理
	 * @param autotest
	 */
	public static void autotestTransfer(Autotest autotest)
	{
		List<PageType> pageList = autotest.getPages().getPage();
		for(PageType page : pageList)
		{
			String clazz = page.getClazz();
			int index = clazz.lastIndexOf(".");
			if(index > 0)
			{
				String pkg = clazz.substring(0, index);
				String name = clazz.substring(index + 1);
				
				autotest.getPages().setPagePackage(pkg);
				page.setClazz(name);
			}
		}
	}
	
	/**
	 * 测试套件包处理
	 * @param suite
	 */
	public static void suiteTransfer(Suite suite)
	{
		List<SuitePageType> suitePageTypeList = suite.getPage();
		for(SuitePageType suitePageType : suitePageTypeList)
		{
			String clazz = suitePageType.getClazz();
			int index = clazz.lastIndexOf(".");
			if(index > 0)
			{
				String pkg = clazz.substring(0, index);
				String name = clazz.substring(index + 1);
				
				suite.setPagePackage(pkg);
				suitePageType.setClazz(name);
			}
		}
	}
	
	public static <T> T getObj(T clazz, String content)
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance(clazz.getClass());
			
			ByteArrayInputStream input = new ByteArrayInputStream(content.getBytes("utf-8"));
			context.createUnmarshaller().unmarshal(input);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return clazz;
	}
}
