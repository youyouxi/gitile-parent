/*
 * 文件名称：SysDeptDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysDeptDao;
import com.gitile.desktop.base.model.SysDept;
import org.springframework.stereotype.Repository;

/**
 * 部门信息数据库操作实现
 */
@Repository
public class SysDeptDaoImpl extends BaseDaoImpl<SysDept> implements SysDeptDao<SysDept> {

}