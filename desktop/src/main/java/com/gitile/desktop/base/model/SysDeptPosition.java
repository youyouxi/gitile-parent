/*
 * 文件名称：SysDeptPosition.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：部门职位信息
 * 模块描述：数据库表对应实体类
 */
public class SysDeptPosition implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysDeptPosition() {}
	public SysDeptPosition(Long id,Long deptId,String name,String remark) {
		this.id=id;
		this.deptId=deptId;
		this.name=name;
		this.remark=remark;
	}
	public SysDeptPosition setNotNull(Long id,Long deptId,String name) {
		this.id=id;
		this.deptId=deptId;
		this.name=name;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private Long deptId;// 部门编号（非空） 
	private String name;// 职位名称（非空） 
	private String remark;// 描述

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}