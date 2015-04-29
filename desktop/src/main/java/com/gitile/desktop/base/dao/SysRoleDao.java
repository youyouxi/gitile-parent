/*
 * 文件名称：SysRoleDao.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao;

import java.util.List;

import com.gitile.core.mybatis.dao.BaseDao;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysApplicationRight;

/**
 * 系统角色数据库操作
 */
public interface SysRoleDao<T> extends BaseDao<T> {

	/**
	 * 根据角色编号获取角色可访问的地址集合
	 * @param roleId
	 * @return
	 */
	List<String> selectRightsByRoleId(String roleId);

	/**
	 * 根据角色编号获取角色可访问的应用
	 * @param roleId
	 * @return
	 */
	List<SysApplication> selectApplicationByRoleId(String roleId);

	/**
	 * 获取角色应用菜单
	 * @param roleId
	 * @param appId
	 * @return
	 */
	List<SysApplicationRight> findUserApplicationMenu(String roleId, Long appId);
	
}