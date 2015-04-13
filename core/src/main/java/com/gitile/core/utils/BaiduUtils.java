package com.gitile.core.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class BaiduUtils {
	
	public final static String RESULT_CODE_SUCCESS = "0";
	public final static Map<String, String> RESULT_CODE_MAP = new HashMap<String, String>();
	
	static {
		RESULT_CODE_MAP.put("1", "服务器内部错误");
		RESULT_CODE_MAP.put("10", "Post上传数据不能超过8M");
		RESULT_CODE_MAP.put("101", "AK参数不存在");
		RESULT_CODE_MAP.put("102", "MCODE参数不存在");
		RESULT_CODE_MAP.put("200", "APP不存在");
		RESULT_CODE_MAP.put("201", "APP被用户自己禁用，请在控制台解禁");
		RESULT_CODE_MAP.put("202", "APP被管理员删除");
		RESULT_CODE_MAP.put("203", "APP类型错误");
		RESULT_CODE_MAP.put("210", "IP校验失败");
		RESULT_CODE_MAP.put("211", "APP SN校验失败");
		RESULT_CODE_MAP.put("220", "APP SN校验失败");
		RESULT_CODE_MAP.put("211", "APP Referer校验失败");
		RESULT_CODE_MAP.put("230", "APP Mcode码校验失败");
		RESULT_CODE_MAP.put("240", "APP 服务被禁用");
		RESULT_CODE_MAP.put("250", "用户不存在");
		RESULT_CODE_MAP.put("251", "用户被自己删除");
		RESULT_CODE_MAP.put("252", "用户被管理员删除");
		RESULT_CODE_MAP.put("260", "服务不存在");
		RESULT_CODE_MAP.put("261", "服务被禁用");
		RESULT_CODE_MAP.put("301", "永久配额超限，限制访问");
		RESULT_CODE_MAP.put("302", "天配额超限，限制访问");
		RESULT_CODE_MAP.put("401", "当前并发量已经超过约定并发配额，限制访问");
		RESULT_CODE_MAP.put("402", "当前并发量已经超过约定并发配额，并且服务总并发量也已经超过设定的总并发配额，限制访问");
	}

	/**
	 * 调用百度地图api(定位较差，只精确到省份城市)
	 * 根据ip地址获取定位地址
	 * @return
	 */
	public static String IptoAddress(String ak,String ip) {
		try {
			if(StringUtils.isEmpty(ak)) {
				ak = "F454f8a5efe5e577997931cc01de3974";
			}
			String result = HttpUtils.reqForGet("http://api.map.baidu.com/location/ip?ak="+ak+"&coor=bd09ll&ip="+ip);
			JSONObject json = JSONObject.parseObject(result);
			String status = json.get("status").toString();
			if(RESULT_CODE_SUCCESS.equals(status)) {
				return ((JSONObject)json.get("content")).get("address").toString();
			} else {
				System.out.println(RESULT_CODE_MAP.get(status));
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
