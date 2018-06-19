package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.model.SuiteRunnerLog;


/**
 * 运行日志服务接口
 * @author
 * @date 
 */
public interface SuiteRunnerLogMapper extends BaseMapper<SuiteRunnerLog>
{
	void save(SuiteRunnerLog suiteRunnerLog);
	
	void delById(String id);
	
	void delBySuiteRunnerId(String suiteRunnerInfoId);
	
	void delByTriggerUserId(String triggerUserId);
	
	List<SuiteRunnerLog> findByRunnerId(String runnerId);
	
	SuiteRunnerLog findById(String id);
}
