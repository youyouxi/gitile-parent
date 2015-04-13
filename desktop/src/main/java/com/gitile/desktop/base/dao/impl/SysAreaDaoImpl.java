/*
 * 文件名称：SysAreaDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysAreaDao;
import com.gitile.desktop.base.model.SysArea;
import org.springframework.stereotype.Repository;

/**
 * 地区信息表数据库操作实现
 */
@Repository
public class SysAreaDaoImpl extends BaseDaoImpl<SysArea> implements SysAreaDao<SysArea> {

}