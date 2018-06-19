package com.webtest.platform.mapping;

import java.util.List;

/**
 * @author 
 * @date
 */
public interface BaseMapper<T>
{
	void save(Object obj);
	
	void update(Object obj);

	/**
	 * @param id
	 */
	void delById(String id);
	
	T getById(String id);
	
	List<T> getAll();
}
