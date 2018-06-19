package com.webtest.platform.mapping;

import java.util.List;

import com.webtest.platform.model.UserInfo;


/**
 * @author
 * @date
 */
public interface UserInfoMapper
{
	List<UserInfo> getAll();
	
	UserInfo getByName(String loginName);
	
	/**
	 * 根据登录名或者邮件地址来查找
	 * @param loginName
	 * @param email
	 * @return
	 */
	UserInfo getByNameOrMail(String loginName, String email);

	/**
	 * @param userInfo
	 */
	void save(UserInfo userInfo);
}
