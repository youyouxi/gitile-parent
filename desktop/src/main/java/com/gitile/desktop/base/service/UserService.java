package com.gitile.desktop.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gitile.desktop.base.model.SysApplication;

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

	/**
	 * 根据角色获取应用
	 * @param roleId
	 * @return
	 */
	List<SysApplication> findUserApplicationByRoleId(String roleId);

}
