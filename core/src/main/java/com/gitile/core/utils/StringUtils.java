package com.gitile.core.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
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
	
}
