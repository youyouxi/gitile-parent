package com.gitile.core.http;

import com.gitile.core.utils.MD5Utils;

/**
 * 验证客户端和平台交互有效性工具类
 *
 */
public class ApiSign {

	/**
	 * 构建sign
	 */
	public static String buildSign(String ServerUrl, String clientKey, String clientScret, String noSignParam) {
		return MD5Utils.getStringMD5(ServerUrl + clientKey + clientScret + noSignParam); 
	}
}