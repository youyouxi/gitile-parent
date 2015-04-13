package com.gitile.mybatis.bean;

import java.util.List;

/**
 * 功能模块
 *
 */
public class Module {

	private String name;// 项目名称
	private String caption;// 项目描述
	private String basePkg;// 存放路径包名
	private String mybatisPath;// mybatis配置存放路径包名
	private String mapperPath;// mapper映像文件存放路径包名
	private List<Table> tables;// 包含的表
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getMybatisPath() {
		return mybatisPath;
	}
	public void setMybatisPath(String mybatisPath) {
		this.mybatisPath = mybatisPath;
	}
	public String getMapperPath() {
		return mapperPath;
	}
	public void setMapperPath(String mapperPath) {
		this.mapperPath = mapperPath;
	}
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public String getBasePkg() {
		return basePkg;
	}
	public void setBasePkg(String basePkg) {
		this.basePkg = basePkg;
	}

}
