/*
 * 文件名称：SysCustomFormPropertyDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysCustomFormPropertyDao;
import com.gitile.desktop.base.model.SysCustomFormProperty;
import org.springframework.stereotype.Repository;

/**
 * 自定义表单属性数据库操作实现
 */
@Repository
public class SysCustomFormPropertyDaoImpl extends BaseDaoImpl<SysCustomFormProperty> implements SysCustomFormPropertyDao<SysCustomFormProperty> {

}