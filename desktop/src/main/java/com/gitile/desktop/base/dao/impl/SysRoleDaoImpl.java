/*
 * 文件名称：SysRoleDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleDao;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysRole;

/**
 * 系统角色数据库操作实现
 */
@Repository
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao<SysRole> {

	@Override
	public List<String> selectRightsByRoleId(String roleId) {
		return sqlSessionTemplate.selectList(getSqlName("selectRightsByRoleId"), roleId);
	}

	@Override
	public List<SysApplication> selectApplicationByRoleId(String roleId) {
		return sqlSessionTemplate.selectList(getSqlName("selectApplicationByRoleId"), roleId);
	}

}