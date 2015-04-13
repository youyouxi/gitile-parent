/*
 * 文件名称：SysRoleDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleDao;
import com.gitile.desktop.base.model.SysRole;
import org.springframework.stereotype.Repository;

/**
 * 系统角色数据库操作实现
 */
@Repository
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao<SysRole> {

}