package com.webtest.platform.controller.api;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.webtest.platform.entity.DataSourceInfo;
import com.webtest.platform.entity.PageInfo;
import com.webtest.platform.mapping.DataSourceInfoMapper;
import com.webtest.platform.mapping.PageInfoMapper;

/**
 * 数据源管理
 * @author
 * @date
 */
@RestController
@RequestMapping("/api/data_source_infos")
public class DataSourceInfoApiController
{
	@Autowired
	private DataSourceInfoMapper dataSourceInfoMapper;
	@Autowired
	private PageInfoMapper pageInfoMapper;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createDataSourceInfo(@RequestParam String pageId)
	{
		PageInfo pageInfo = pageInfoMapper.getById(pageId);
		if(pageInfo != null)
		{
			String pageName = pageInfo.getName();

			DataSourceInfo dataSourceInfo = new DataSourceInfo();
			dataSourceInfo.setPageId(pageId);
			dataSourceInfo.setProjectId(pageInfo.getProjectId());
			dataSourceInfo.setCreateTime(new Date());
			dataSourceInfo.setName(pageName); //TODO 这里要考虑不能重复的问题

			dataSourceInfoMapper.save(dataSourceInfo);

			return dataSourceInfo.getId();
		}

		return null;
	}
}
