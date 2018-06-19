package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.entity.FieldLocator;

/**
 * @author 
 */
public interface FieldLocatorMapper extends BaseMapper<FieldLocator>
{
    /**
     * 根据元素（字段）ID来查找所有的定位信息
     * @param fieldId 元素ID
     * @return 定位信息列表
     */
    List<FieldLocator> getAllByFieldId(String fieldId);
}
