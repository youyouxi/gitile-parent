package com.gitile.mybatis.bean;

/**
 * 表外键
 *
 */
public class TableForeign {
	
	private String name;// 外键名称
	
	private String column;// 外键字段
	
	private String relate;// 关联表
	
	private String relateColumn;// 关联字段
	
	private String delete;// 删除时相应操作
	
	private String update;// 更新是相应操作

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getRelate() {
		return relate;
	}

	public void setRelate(String relate) {
		this.relate = relate;
	}

	public String getRelateColumn() {
		return relateColumn;
	}

	public void setRelateColumn(String relateColumn) {
		this.relateColumn = relateColumn;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getUpdate() {
		return update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

}
