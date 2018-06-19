package com.webtest.platform.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtest.platform.mapping.SuiteRunnerLogMapper;
import com.webtest.platform.model.SuiteRunnerLog;

/**
 * 运行日志
 * @author 
 * @date
 */
@RestController
@RequestMapping("/api/suite_runner_log")
public class SuiteRunnerLogApiController
{
	@Autowired
	private SuiteRunnerLogMapper suiteRunnerLogMapper;
	
	@RequestMapping(value = "/{runnerId}", method = RequestMethod.GET)
	public List<SuiteRunnerLog> list(@PathVariable String runnerId)
	{
		return suiteRunnerLogMapper.findByRunnerId(runnerId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SuiteRunnerLog detail(@RequestParam String id)
	{
		return suiteRunnerLogMapper.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void del(@RequestParam String id)
	{
		suiteRunnerLogMapper.delById(id);
	}
}
