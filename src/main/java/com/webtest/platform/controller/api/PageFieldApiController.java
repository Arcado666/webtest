package com.webtest.platform.controller.api;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webtest.platform.entity.PageField;
import com.webtest.platform.mapping.PageFieldMapper;

/**
 * @author
 * @date
 */
@RestController
@RequestMapping("/api/page_fields/{pageId}")
public class PageFieldApiController
{
	@Autowired
	private PageFieldMapper pageFieldMapper;
	
	@ApiOperation("/list")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PageField> list(@PathVariable String pageId)
	{
		return pageFieldMapper.getByPageId(pageId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@PathVariable String pageId, @RequestBody PageField pageField)
	{
		pageField.setPageId(pageId);
		pageFieldMapper.save(pageField);
		return pageField.getId();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void update(@PathVariable String pageId, @RequestBody PageField pageField)
	{
		pageFieldMapper.update(pageField);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void del(@PathVariable String pageId, @PathVariable String id)
	{
		pageFieldMapper.delById(id);
	}
}
