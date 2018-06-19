package com.webtest.platform.controller.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.webtest.platform.mapping.AttachConfigMapper;
import com.webtest.platform.mapping.AttachmentMapper;
import com.webtest.platform.mapping.OptionsMapper;
import com.webtest.platform.model.AttachConfig;
import com.webtest.platform.model.Attachment;
import com.webtest.platform.model.Options;
import com.webtest.platform.security.UserDetail;

/**
 * @author
 * @date
 */
@RestController
@RequestMapping("/api/attachments")
public class AttachmentApiController
{
	@Autowired
	private AttachmentMapper attachmentMapper;
	@Autowired
	private AttachConfigMapper attachConfigMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(MultipartFile file, Attachment attachment)
	{
		UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String ownerId = userDetail.getId();
		
		attachment.setOwnerId(ownerId);
		attachment.setCreateTime(new Date());
		
		Options options = optionsMapper.getByKey("attachRoot");
		if(options != null)
		{
			String attachRoot = options.getOptValue();
			attachment.setRelativePath(attachRoot);

			try(InputStream input = file.getInputStream();
					OutputStream output = new FileOutputStream(new File(attachRoot, attachment.getFileName())))
			{
				IOUtils.copy(input, output);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		String configId;
		List<AttachConfig> attachConfigList = attachConfigMapper.getAll();
		if(CollectionUtils.isEmpty(attachConfigList))
		{
			AttachConfig config = new AttachConfig();
			config.setName("for demo");
			attachConfigMapper.save(config);
			configId = config.getId();
		}
		else
		{
			configId = attachConfigList.get(0).getId();
		}
		attachment.setConfigId(configId);
		
		attachmentMapper.save(attachment);
	}
	
	/**
	 * 删除附件
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void del(@PathVariable String id)
	{
		attachmentMapper.delById(id);
	}
	
	@RequestMapping(value = "/count/{belongId}", method = RequestMethod.GET)
	public int count(@PathVariable String belongId)
	{
		return attachmentMapper.countByBelongId(belongId);
	}
}
