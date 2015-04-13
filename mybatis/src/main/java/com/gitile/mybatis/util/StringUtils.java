package com.gitile.mybatis.util;

import java.io.File;

public class StringUtils {
	
	public static final String LINE = "\r\n";
	public static final String TAB = "\t";
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str!=null && str.trim().length()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
	/**
	 * 包名转换成实际路径
	 * @param packagesName
	 * @return
	 */
	public static String pkgToPath(String packagesName) {
		return (packagesName.replace("/", "\\")).replace(".", "\\");
	}
	
	/**
	 * 包名转换成实际路径
	 * @param packagesName
	 * @return
	 */
	public static String pkgToPathMaven(String packagesName) {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\" + StringUtils.pkgToPath(packagesName);
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
	
	/**
	 * 构建项目资源路径
	 * @param packagesName
	 * @return
	 */
	public static String buildResourcesPathMaven(String mpath) {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\" + mpath;
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
	
	/**
	 * 把下划线后一位的字母变大写
	 * @param tableName
	 * @return
	 */
	public static String dealLine(String tableName, boolean isUpperFirst) {
		if(isUpperFirst) {
			tableName = tableName.substring(0, 1).toUpperCase() + tableName.subSequence(1, tableName.length());
		}
		// 处理下划线情况，把下划线后一位的字母变大写；
		tableName = dealName(tableName);
		return tableName;
	}
	
	/**
	 * 下划线后一位字母大写
	 * @param tableName
	 * @return
	 */
	public static String dealName(String columnName) {
		if (columnName.contains("_")) {
			StringBuffer names = new StringBuffer();
			String arrayName[] = columnName.split("_");
			names.append(arrayName[0]);
			for (int i = 1; i < arrayName.length; i++) {
				String arri = arrayName[i];
				String tmp = arri.substring(0, 1).toUpperCase()
						+ arri.substring(1, arri.length());
				names.append(tmp);
			}
			columnName = names.toString();
		}
		return columnName;
	}

	public static int toInt(String str) {
		try {
			if(isNotEmpty(str)) {
				int result = Integer.valueOf(str);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean toBoolean(String str) {
		try {
			if(isNotEmpty(str)) {
				boolean result = Boolean.valueOf(str);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
