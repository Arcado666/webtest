/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webtest.platform.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webtest.platform.entity.PageField;
import com.webtest.platform.mapping.PageFieldMapper;
import com.webtest.platform.schemas.autotest.FieldTypeEnum;
import com.webtest.platform.schemas.autotest.StrategyEnum;

/**
 * @author 
 * @date 
 */
@Controller
@RequestMapping("/page_field")
public class PageFieldController
{
	@Autowired
	private PageFieldMapper fieldMapper;

	@RequestMapping(value = "/list")
	public String fieldTable(@RequestParam String pageId, Model model)
	{
		model.addAttribute("fieldType", FieldTypeEnum.values());
		model.addAttribute("strategyType", StrategyEnum.values());
		model.addAttribute("pageId", pageId);
		return "page_info/page_field_table";
	}

	@RequestMapping(value = "/list_by_field_id")
	public String fieldTableById(@RequestParam String id, Model model)
	{
		PageField field = fieldMapper.getById(id);

		model.addAttribute("fieldType", FieldTypeEnum.values());
		model.addAttribute("strategyType", StrategyEnum.values());

		if(field != null)
		{
			model.addAttribute("pageId", field.getPageId());
		}

		return "page_info/page_field_table";
	}
}
