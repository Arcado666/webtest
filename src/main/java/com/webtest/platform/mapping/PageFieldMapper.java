package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.entity.PageField;


/**
 * @author 
 * @date 
 */
public interface PageFieldMapper extends BaseMapper<PageField>
{
	List<PageField> getByPageId(String pageId);
}
