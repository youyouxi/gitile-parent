/*
 * 文件名称：SysApplicationDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysApplicationDao;
import com.gitile.desktop.base.model.SysApplication;
import org.springframework.stereotype.Repository;

/**
 * 应用信息数据库操作实现
 */
@Repository
public class SysApplicationDaoImpl extends BaseDaoImpl<SysApplication> implements SysApplicationDao<SysApplication> {

}