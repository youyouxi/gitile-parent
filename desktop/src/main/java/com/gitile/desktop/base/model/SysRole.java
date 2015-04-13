/*
 * 文件名称：SysRole.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：系统角色
 * 模块描述：数据库表对应实体类
 */
public class SysRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysRole() {}
	public SysRole(String id,String name,Long levelId,String remark) {
		this.id=id;
		this.name=name;
		this.levelId=levelId;
		this.remark=remark;
	}
	public SysRole setNotNull(String id,String name,Long levelId) {
		this.id=id;
		this.name=name;
		this.levelId=levelId;
		return this;
	}
	/**属性**/
	private String id;// 角色编号（非空） 
	private String name;// 角色名称（非空） 
	private Long levelId;// 审批级别（非空） 
	private String remark;// 角色描述

	/**属性Get、Set函数**/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}