package com.gitile.weixin.utils.lang;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 *
 */
public class JsonUtil {

	private JsonUtil(){}

	public static <T> T parseObject(String json,Class<T> clazz){
		return JSON.parseObject(json, clazz);
	}

	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}
}
