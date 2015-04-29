package com.gitile.desktop.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysApplicationRight;
import com.gitile.desktop.base.model.SysUser;

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

	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	SysUser findUser(Long id);

	/**
	 * 更新用户信息
	 * @param update
	 * @return
	 */
	boolean updateUser(SysUser update);

	/**
	 * 获取应用的一级菜单
	 * @param roleId
	 * @param l
	 * @return
	 */
	List<SysApplicationRight> findUserApplicationMenu(String roleId, Long appId);

}
