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

package com.webtest.platform.servlet;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.TagWriter;

import com.webtest.utils.StringUtils;

/**
 * @author 
 * @date 
 */
public class LinkTag extends AbstractContextHtmlElementTag
{

	/**  */
	private static final long	serialVersionUID	= 1L;
	
	private String href;
	private String rel;

	@Override
	protected int writeTagContent(TagWriter tagWriter) throws JspException
	{
		tagWriter.startTag("link");
		tagWriter.writeAttribute("href", getContextUrl(href));
		tagWriter.writeAttribute("rel", StringUtils.isBlank(rel) ? "stylesheet" : rel);
		tagWriter.endTag(true);
		return 0;
	}

	public String getHref()
	{
		return href;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	/**
	 * @return the rel
	 */
	public String getRel()
	{
		return rel;
	}

	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel)
	{
		this.rel = rel;
	}

}
