/*
 * 文件名称：SysRoleLevel.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：角色审批级别
 * 模块描述：数据库表对应实体类
 */
public class SysRoleLevel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysRoleLevel() {}
	public SysRoleLevel(Long id,String name,Integer sort) {
		this.id=id;
		this.name=name;
		this.sort=sort;
	}
	public SysRoleLevel setNotNull(Long id,String name,Integer sort) {
		this.id=id;
		this.name=name;
		this.sort=sort;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String name;// 员工编号（非空） 
	private Integer sort;// 上级领导（非空） 

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}