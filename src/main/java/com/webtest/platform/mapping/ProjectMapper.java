package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.model.Project;


/**
 * @author
 * @date
 */
public interface ProjectMapper
{
	Project getById(String id);
	List<Project> getAll();
	void save(Project project);
	void update(Project project);
	void delById(String id);
}
