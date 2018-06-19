package com.webtest.platform.mapping;


import com.webtest.platform.model.DataSourceDetail;

import java.util.List;

public interface DataSourceDetailMapper extends BaseMapper<DataSourceDetail> {
	List<DataSourceDetail> findByDataSourceId(String dataSourceId);
}