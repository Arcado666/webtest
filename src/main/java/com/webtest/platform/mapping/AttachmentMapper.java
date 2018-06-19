package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.model.Attachment;


/**
 * @author 
 * @date 
 */
public interface AttachmentMapper extends BaseMapper<Attachment>
{
	List<Attachment> getByBelongId(String belongId);
	
	int countByBelongId(String belongId);
}
