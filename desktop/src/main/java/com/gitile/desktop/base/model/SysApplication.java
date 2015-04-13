/*
 * 文件名称：SysApplication.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：应用信息
 * 模块描述：数据库表对应实体类
 */
public class SysApplication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysApplication() {}
	public SysApplication(Long id,String name,String icon,Short simple,Short resize,String height,String width,String appUrl,Short authorize,String remark) {
		this.id=id;
		this.name=name;
		this.icon=icon;
		this.simple=simple;
		this.resize=resize;
		this.height=height;
		this.width=width;
		this.appUrl=appUrl;
		this.authorize=authorize;
		this.remark=remark;
	}
	public SysApplication setNotNull(Long id,String name,String icon,Short simple,Short resize,String height,String width,String appUrl,Short authorize) {
		this.id=id;
		this.name=name;
		this.icon=icon;
		this.simple=simple;
		this.resize=resize;
		this.height=height;
		this.width=width;
		this.appUrl=appUrl;
		this.authorize=authorize;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String name;// 应用名称（非空） 
	private String icon;// 应用图标（非空） 
	private Short simple;// 是否透明（1：透明，0：不透明）（非空） 
	private Short resize;// 调整大小（1：可以，0：不可以）（非空） 
	private String height;// 窗口高度（非空） 
	private String width;// 窗口宽度（非空） 
	private String appUrl;// 访问路径（非空） 
	private Short authorize;// 是否授权（非空） 
	private String remark;// 备注

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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Short getSimple() {
		return simple;
	}
	public void setSimple(Short simple) {
		this.simple = simple;
	}
	public Short getResize() {
		return resize;
	}
	public void setResize(Short resize) {
		this.resize = resize;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getAppUrl() {
		return appUrl;
	}
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	public Short getAuthorize() {
		return authorize;
	}
	public void setAuthorize(Short authorize) {
		this.authorize = authorize;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}