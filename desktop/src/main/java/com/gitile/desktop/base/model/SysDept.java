/*
 * 文件名称：SysDept.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：部门信息
 * 模块描述：数据库表对应实体类
 */
public class SysDept implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysDept() {}
	public SysDept(Long id,Long parentId,String name,Integer sort,Short status,String propertys) {
		this.id=id;
		this.parentId=parentId;
		this.name=name;
		this.sort=sort;
		this.status=status;
		this.propertys=propertys;
	}
	public SysDept setNotNull(Long id,Long parentId,String name,Integer sort,Short status) {
		this.id=id;
		this.parentId=parentId;
		this.name=name;
		this.sort=sort;
		this.status=status;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private Long parentId;// 父级编号（非空） 
	private String name;// 部门名称（非空） 
	private Integer sort;// 排序（升序）（非空） 
	private Short status;// 公司状态(1:正常状态,2:已删除状态)（非空） 
	private String propertys;// 扩展表单内容

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public String getPropertys() {
		return propertys;
	}
	public void setPropertys(String propertys) {
		this.propertys = propertys;
	}

}