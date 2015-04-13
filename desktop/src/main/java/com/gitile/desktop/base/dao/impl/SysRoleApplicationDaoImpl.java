/*
 * 文件名称：SysRoleApplicationDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysRoleApplicationDao;
import com.gitile.desktop.base.model.SysRoleApplication;
import org.springframework.stereotype.Repository;

/**
 * 角色可使用应用数据库操作实现
 */
@Repository
public class SysRoleApplicationDaoImpl extends BaseDaoImpl<SysRoleApplication> implements SysRoleApplicationDao<SysRoleApplication> {

}