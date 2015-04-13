/*
 * 文件名称：SysApplicationRightDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysApplicationRightDao;
import com.gitile.desktop.base.model.SysApplicationRight;
import org.springframework.stereotype.Repository;

/**
 * 应用菜单权限数据库操作实现
 */
@Repository
public class SysApplicationRightDaoImpl extends BaseDaoImpl<SysApplicationRight> implements SysApplicationRightDao<SysApplicationRight> {

}