/*
 * 文件名称：SysArea.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.Date;

/**
 * 名称：地区信息表
 * 模块描述：数据库表对应实体类
 */
public class SysArea implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysArea() {}
	public SysArea(String id,String name,String displayName,Integer sort,Date createdTime,Date lastModifiedTime) {
		this.id=id;
		this.name=name;
		this.displayName=displayName;
		this.sort=sort;
		this.createdTime=createdTime;
		this.lastModifiedTime=lastModifiedTime;
	}
	public SysArea setNotNull(String id,String name,String displayName,Integer sort,Date createdTime,Date lastModifiedTime) {
		this.id=id;
		this.name=name;
		this.displayName=displayName;
		this.sort=sort;
		this.createdTime=createdTime;
		this.lastModifiedTime=lastModifiedTime;
		return this;
	}
	/**属性**/
	private String id;// 编号（非空） 
	private String name;// 名称（非空） 
	private String displayName;// 全称（非空） 
	private Integer sort;// 排序（非空） 
	private Date createdTime;// 创建时间（非空） 
	private Date lastModifiedTime;// 最后修改时间（非空） 

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
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
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