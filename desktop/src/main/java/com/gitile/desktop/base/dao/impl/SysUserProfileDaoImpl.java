/*
 * 文件名称：SysUserProfileDaoImpl.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.dao.impl;

import com.gitile.core.mybatis.dao.BaseDaoImpl;
import com.gitile.desktop.base.dao.SysUserProfileDao;
import com.gitile.desktop.base.model.SysUserProfile;
import org.springframework.stereotype.Repository;

/**
 * 账号扩展信息数据库操作实现
 */
@Repository
public class SysUserProfileDaoImpl extends BaseDaoImpl<SysUserProfile> implements SysUserProfileDao<SysUserProfile> {

}