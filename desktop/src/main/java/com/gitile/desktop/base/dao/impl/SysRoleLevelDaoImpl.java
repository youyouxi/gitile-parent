/*
 * 文件名称：SysRoleLevelDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleLevelDao;
import com.gitile.desktop.base.model.SysRoleLevel;
import org.springframework.stereotype.Repository;

/**
 * 角色审批级别数据库操作实现
 */
@Repository
public class SysRoleLevelDaoImpl extends BaseDaoImpl<SysRoleLevel> implements SysRoleLevelDao<SysRoleLevel> {

}