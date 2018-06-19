package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.entity.PageInfo;


/**
 * @author
 * @date 
 */
public interface PageInfoMapper
{
	List<PageInfo> getAll();
	List<PageInfo> getAllByProjectId(String projectId);
	List<PageInfo> getAllWithContentByProjectId(String projectId);
	
	void save(PageInfo pageInfo);
	int getTotalNum();
	int getCountByProjectId(String projectId);
	
	PageInfo getById(String id);
	List<PageInfo> getAllIds();
	void update(PageInfo pageInfo);
	void delById(String id);
}
