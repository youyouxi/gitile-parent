/*
 * 文件名称：SysRoleApplicationRight.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：角色可访问权限
 * 模块描述：数据库表对应实体类
 */
public class SysRoleApplicationRight implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysRoleApplicationRight() {}
	public SysRoleApplicationRight(Long id,String roleId,Long appId,Long rightId) {
		this.id=id;
		this.roleId=roleId;
		this.appId=appId;
		this.rightId=rightId;
	}
	public SysRoleApplicationRight setNotNull(Long id,String roleId,Long appId,Long rightId) {
		this.id=id;
		this.roleId=roleId;
		this.appId=appId;
		this.rightId=rightId;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String roleId;// 角色编号（非空） 
	private Long appId;// 应用编号（非空） 
	private Long rightId;// 权限编号（非空） 

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
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	public Long getRightId() {
		return rightId;
	}
	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

}