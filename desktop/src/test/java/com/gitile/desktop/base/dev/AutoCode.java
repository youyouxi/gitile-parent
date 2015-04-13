package com.gitile.desktop.base.dev;

import java.sql.SQLException;

import com.gitile.mybatis.BuildCode;

public class AutoCode {
	
	public static void main(String[] args) {
		buildConfig();
		buildModel();
		buildMapper();
		buildDao();
	}
	
	private static void buildConfig() {
		try {
			BuildCode.buildConfig("jdbc:mysql://localhost:3306/desktop", "root", "");
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
