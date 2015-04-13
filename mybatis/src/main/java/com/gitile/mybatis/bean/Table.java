package com.gitile.mybatis.bean;

import java.util.List;

/**
 * 表结构
 *
 */
public class Table {
	
	private String name;// 表名
	private String comment;// 表注解
	
	private List<TableColumn> columns;// 表字段
	private List<TablePrimary> primarys;// 表主键
	private List<TableForeign> foreigns;// 表外键
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<TableColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	public List<TableForeign> getForeigns() {
		return foreigns;
	}
	public void setForeigns(List<TableForeign> foreigns) {
		this.foreigns = foreigns;
	}
	public List<TablePrimary> getPrimarys() {
		return primarys;
	}
	public void setPrimarys(List<TablePrimary> primarys) {
		this.primarys = primarys;
	}
	
}
