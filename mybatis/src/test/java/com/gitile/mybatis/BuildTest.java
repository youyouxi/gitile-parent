package com.gitile.mybatis;

import java.sql.SQLException;

import com.gitile.mybatis.BuildCode;

public class BuildTest {
	
	public static void main(String[] args) {
		buildConfig();
		buildModel();
		buildMapper();
		buildDao();
	}
	
	/**
	 * 根据数据库结构自动生成配置文件
	 * 生成后，还需要修改以下几点
	 * 1、需要修改项目包名
	 * 2、表的注解
	 * 
	 */
	private static void buildConfig() {
		try {
			BuildCode.buildConfig("jdbc:mysql://localhost:3306/nei_desktop", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void buildModel() {
		BuildCode.buildModel(BuildCode.DEFAULT_CONFIG_FILE);
	}
	
	private static void buildMapper() {
		BuildCode.buildMybatis(BuildCode.DEFAULT_CONFIG_FILE);
	}
	
	private static void buildDao() {
		BuildCode.buildDao(BuildCode.DEFAULT_CONFIG_FILE);
	}
	
}
