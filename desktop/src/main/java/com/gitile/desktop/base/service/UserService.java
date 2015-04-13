package com.gitile.desktop.base.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户相关操作
 *
 */
public interface UserService {

	/**
	 * 用户登录
	 * @param request
	 * @param username
	 * @param password
	 * @param checkcode
	 * @return
	 */
	int login(HttpServletRequest request, String username, String password, String checkcode);

}
