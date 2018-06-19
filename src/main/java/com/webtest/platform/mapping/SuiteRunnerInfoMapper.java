package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.model.SuiteRunnerInfo;


/**
 * @author 
 * @date 
 */
public interface SuiteRunnerInfoMapper
{
	List<SuiteRunnerInfo> getAll();
	List<SuiteRunnerInfo> getAllByProjectId(String projectId);
	List<SuiteRunnerInfo> getAllWithContentByProjectId(String projectId);
	
	SuiteRunnerInfo getById(String id);
	int getCountByProjectId(String projectId);
	
	void save(SuiteRunnerInfo suiteRunnerInfo);
	void update(SuiteRunnerInfo suiteRunnerInfo);
	
	void delById(String id);
}
