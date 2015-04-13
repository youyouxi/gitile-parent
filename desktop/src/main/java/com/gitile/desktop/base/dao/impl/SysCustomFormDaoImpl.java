/*
 * 文件名称：SysCustomFormDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysCustomFormDao;
import com.gitile.desktop.base.model.SysCustomForm;
import org.springframework.stereotype.Repository;

/**
 * 自定义表单数据库操作实现
 */
@Repository
public class SysCustomFormDaoImpl extends BaseDaoImpl<SysCustomForm> implements SysCustomFormDao<SysCustomForm> {

}