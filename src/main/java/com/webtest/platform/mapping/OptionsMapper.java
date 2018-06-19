package com.webtest.platform.mapping;

import com.webtest.platform.model.Options;

/**
 * @author 
 * @date 
 */
public interface OptionsMapper extends BaseMapper<Options>
{
	Options getByKey(String key);
}
