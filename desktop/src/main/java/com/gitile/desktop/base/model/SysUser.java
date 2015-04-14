/*
 * 文件名称：SysUser.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 14:51
 */
package com.gitile.desktop.base.model;

import java.util.Date;

/**
 * 名称：账号信息
 * 模块描述：数据库表对应实体类
 */
public class SysUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysUser() {}
	public SysUser(Long id,String roleId,String username,String password,String salt,Integer failureLoginCount,Date lastLoginTime,Short status,Date createdTime,Date lastModifiedTime) {
		this.id=id;
		this.roleId=roleId;
		this.username=username;
		this.password=password;
		this.salt=salt;
		this.failureLoginCount=failureLoginCount;
		this.lastLoginTime=lastLoginTime;
		this.status=status;
		this.createdTime=createdTime;
		this.lastModifiedTime=lastModifiedTime;
	}
	public SysUser setNotNull(Long id,String roleId,String username,String password,String salt,Integer failureLoginCount,Date lastLoginTime,Short status,Date createdTime,Date lastModifiedTime) {
		this.id=id;
		this.roleId=roleId;
		this.username=username;
		this.password=password;
		this.salt=salt;
		this.failureLoginCount=failureLoginCount;
		this.lastLoginTime=lastLoginTime;
		this.status=status;
		this.createdTime=createdTime;
		this.lastModifiedTime=lastModifiedTime;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String roleId;// 所属角色（非空） 
	private String username;// 用户名（非空） 
	private String password;// 加密密码（非空） 
	private String salt;// 加密秘钥（非空） 
	private Integer failureLoginCount;// 登录失败次数（非空） 
	private Date lastLoginTime;// 最后登录时间（非空） 
	private Short status;// 用户状态(1:正常使用状态,2:帐号冻结状态,3:帐号删除状态)（非空） 
	private Date createdTime;// 创建时间（非空） 
	private Date lastModifiedTime;// 最后修改时间（非空） 

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public Integer getFailureLoginCount() {
		return failureLoginCount;
	}
	public void setFailureLoginCount(Integer failureLoginCount) {
		this.failureLoginCount = failureLoginCount;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

}