/*
 * 文件名称：SysCustomForm.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：自定义表单
 * 模块描述：数据库表对应实体类
 */
public class SysCustomForm implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysCustomForm() {}
	public SysCustomForm(String id,String name,String remarks) {
		this.id=id;
		this.name=name;
		this.remarks=remarks;
	}
	public SysCustomForm setNotNull(String id,String name) {
		this.id=id;
		this.name=name;
		return this;
	}
	/**属性**/
	private String id;// 表单编号（非空） 
	private String name;// 表单名称（非空） 
	private String remarks;// 备注

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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}