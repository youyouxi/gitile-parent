/*
 * 文件名称：SysDeptPositionDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysDeptPositionDao;
import com.gitile.desktop.base.model.SysDeptPosition;
import org.springframework.stereotype.Repository;

/**
 * 部门职位信息数据库操作实现
 */
@Repository
public class SysDeptPositionDaoImpl extends BaseDaoImpl<SysDeptPosition> implements SysDeptPositionDao<SysDeptPosition> {

}