package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.entity.DataSourceInfo;


/**
 * @author 
 * @date
 */
public interface DataSourceInfoMapper
{
	List<DataSourceInfo> getAll();
	List<DataSourceInfo> getAllByProjectId(String projectId);
	List<DataSourceInfo> getAllByPageId(String pageId);
	List<DataSourceInfo> getAllWithContentByProjectId(String projectId);
	List<DataSourceInfo> getAllIds();
	
	DataSourceInfo getById(String id);
	int getCountByProjectId(String projectId);
	
	void save(DataSourceInfo dataSourceInfo);
	void update(DataSourceInfo dataSourceInfo);
	
	void delById(String id);
}
