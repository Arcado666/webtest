package com.webtest.platform.controller.api;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtest.platform.mapping.SuiteRunnerInfoMapper;
import com.webtest.platform.model.SuiteRunnerInfo;
import com.webtest.platform.schemas.suite.Suite;
import com.webtest.utils.StringUtils;

/**
 * 测试套件管理
 * @author suren
 * @date 2017年1月23日 上午7:38:33
 */
@RestController
@RequestMapping("/api/suite_runner_infos")
public class SuiteRunnerInfoApiController
{
	@Autowired
	private SuiteRunnerInfoMapper suiteRunnerInfoMapper;
	
	@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public List<SuiteRunnerInfo> suiteRunnerInfoList(@PathVariable String projectId)
	{
		return suiteRunnerInfoMapper.getAllByProjectId(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SuiteRunnerInfo suiteRunnerInfoEdit(@RequestParam String id)
	{
		return suiteRunnerInfoMapper.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void suiteRunnerInfoDel(@RequestParam String id)
	{
		suiteRunnerInfoMapper.delById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void suiteRunnerInfoSave(@RequestBody SuiteRunnerInfo suiteRunnerInfo)
	{
		Suite suite = suiteRunnerInfo.getSuite();
		
		try
		{
			JAXBContext context = JAXBContext.newInstance(Suite.class);
			Marshaller marshaller = context.createMarshaller();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			marshaller.marshal(suite, out);
			
			suiteRunnerInfo.setContent(out.toString("UTF-8"));
			if(StringUtils.isNotBlank(suiteRunnerInfo.getId()))
			{
				suiteRunnerInfoMapper.update(suiteRunnerInfo);
			}
			else
			{
				suiteRunnerInfo.setCreateTime(new Date());
				suiteRunnerInfoMapper.save(suiteRunnerInfo);
			}
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
