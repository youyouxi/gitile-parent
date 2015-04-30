/*
 * 文件名称：SysApplicationRight.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月29日 16:10
 */
package com.gitile.desktop.base.model;


/**
 * 名称：应用菜单权限
 * 模块描述：数据库表对应实体类
 */
public class SysApplicationRight implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysApplicationRight() {}
	public SysApplicationRight(Long id,String icon,Long appId,Long parentId,String name,Short rightType,String rightUrl,Integer sort) {
		this.id=id;
		this.icon=icon;
		this.appId=appId;
		this.parentId=parentId;
		this.name=name;
		this.rightType=rightType;
		this.rightUrl=rightUrl;
		this.sort=sort;
	}
	public SysApplicationRight setNotNull(Long id,Long appId,Long parentId,String name,Short rightType,Integer sort) {
		this.id=id;
		this.appId=appId;
		this.parentId=parentId;
		this.name=name;
		this.rightType=rightType;
		this.sort=sort;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String icon;// 图标
	private Long appId;// 应用编号（非空） 
	private Long parentId;// 父类编号（非空） 
	private String name;// 名称（非空） 
	private Short rightType;// 类型（1：分类、2：菜单、3：权限）（非空） 
	private String rightUrl;// 权限地址
	private Integer sort;// 排序（非空） 

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Long getAppId() {
		return appId;
	}
	public void setAppId(Long appId) {
		this.appId = appId;
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
	public Short getRightType() {
		return rightType;
	}
	public void setRightType(Short rightType) {
		this.rightType = rightType;
	}
	public String getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

}