
package com.webtest.platform.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webtest.platform.mapping.ProjectMapper;
import com.webtest.platform.model.Project;

/**
 * 项目管理
 * @author
 * @date 
 */
@Controller
@RequestMapping("/project")
public class ProjectController
{
	@Autowired
	private ProjectMapper projectMapper;
	
	@RequestMapping("/list")
	public String list()
	{
		return "project_list";
	}
	
	@RequestMapping("/edit")
	public String edit(@RequestParam(required = false) String id, Model model)
	{
		Project project = projectMapper.getById(id);
		model.addAttribute("project", project);
		
		return "project_edit";
	}
	
	@RequestMapping("/del")
	public void del(@RequestParam String id)
	{
		projectMapper.delById(id);
	}
}
