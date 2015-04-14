/*
 * 文件名称：SysUserDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 14:51
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysUserDao;
import com.gitile.desktop.base.model.SysUser;
import org.springframework.stereotype.Repository;

/**
 * 账号信息数据库操作实现
 */
@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao<SysUser> {

}