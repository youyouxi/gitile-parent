/*
 * 文件名称：SysRoleApplication.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：角色可使用应用
 * 模块描述：数据库表对应实体类
 */
public class SysRoleApplication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysRoleApplication() {}
	public SysRoleApplication(Long id,String roleId,Long appId) {
		this.id=id;
		this.roleId=roleId;
		this.appId=appId;
	}
	public SysRoleApplication setNotNull(Long id,String roleId,Long appId) {
		this.id=id;
		this.roleId=roleId;
		this.appId=appId;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String roleId;// 角色编号（非空） 
	private Long appId;// 应用编号（非空） 

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

}