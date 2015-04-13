/*
 * 文件名称：SysApplicationRight.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
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
	public SysApplicationRight(Long id,Long appId,Long parentId,String name,Short rightType,String rightUrl) {
		this.id=id;
		this.appId=appId;
		this.parentId=parentId;
		this.name=name;
		this.rightType=rightType;
		this.rightUrl=rightUrl;
	}
	public SysApplicationRight setNotNull(Long id,Long appId,Long parentId,String name,Short rightType) {
		this.id=id;
		this.appId=appId;
		this.parentId=parentId;
		this.name=name;
		this.rightType=rightType;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private Long appId;// 应用编号（非空） 
	private Long parentId;// 父类编号（非空） 
	private String name;// 名称（非空） 
	private Short rightType;// 类型（1：分类、2：菜单、3：权限）（非空） 
	private String rightUrl;// 权限地址

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}