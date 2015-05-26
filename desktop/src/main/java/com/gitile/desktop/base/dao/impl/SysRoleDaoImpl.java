/*
 * 文件名称：SysRoleDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年05月26日 13:29
 */
package com.gitile.desktop.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleDao;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysApplicationRight;
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

	@Override
	public List<SysApplicationRight> findUserApplicationMenu(String roleId, Long appId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("appId", appId);
		return sqlSessionTemplate.selectList(getSqlName("findUserApplicationMenu"), param);
	}

}