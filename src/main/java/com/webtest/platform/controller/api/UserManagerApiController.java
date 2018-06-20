package com.webtest.platform.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 
 * @date 
 */
@RestController
@RequestMapping("/api/user_manager")
public class UserManagerApiController
{
	@Autowired
	private SessionRegistry sessionRegistry;
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public int onLineCount()
	{
		return sessionRegistry.getAllPrincipals().size();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Object> onLineUser()
	{
		return sessionRegistry.getAllPrincipals();
	}

}
