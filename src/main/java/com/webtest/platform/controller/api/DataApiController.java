package com.webtest.platform.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtest.utils.EncryptorUtil;

/**
 * @author
 * @date
 */
@RestController
@RequestMapping("/api/data")
public class DataApiController
{
	@RequestMapping(value = "/encrypt", method = RequestMethod.GET)
	public String encrypt(@RequestParam String plainText)
	{
		String encryptText = EncryptorUtil.encryptWithBase64(plainText);
		
		return encryptText;
	}
}
