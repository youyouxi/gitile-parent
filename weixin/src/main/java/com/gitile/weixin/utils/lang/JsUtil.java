package com.gitile.weixin.utils.lang;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.gitile.weixin.bean.pay.PayPackage;

/**
 * 微信Js相关工具类
 *
 */
public class JsUtil {

	/**
	 * 生成 config接口 signature
	 * @param noncestr
	 * @param jsapi_ticket
	 * @param timestamp
	 * @param url
	 * @return
	 */
	public static String generateConfigSignature(String noncestr,String jsapi_ticket,String timestamp,String url){
		Map<String, String> map = new HashMap<String, String>();
		map.put("noncestr", noncestr);
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("timestamp", timestamp);
		map.put("url", url);
		return SignatureUtil.generatePaySign(map, null);
	}

	/**
	 * 生成 config接口注入权限验证 JSON
	 * @param jsapi_ticket
	 * @param debug
	 * @param appId
	 * @param url
	 * @param jsApiList
	 *  onMenuShareTimeline
		onMenuShareAppMessage
		onMenuShareQQ
		onMenuShareWeibo
		startRecord
		stopRecord
		onVoiceRecordEnd
		playVoice
		pauseVoice
		stopVoice
		onVoicePlayEnd
		uploadVoice
		downloadVoice
		chooseImage
		previewImage
		uploadImage
		downloadImage
		translateVoice
		getNetworkType
		openLocation
		getLocation
		hideOptionMenu
		showOptionMenu
		hideMenuItems
		showMenuItems
		hideAllNonBaseMenuItem
		showAllNonBaseMenuItem
		closeWindow
		scanQRCode
		chooseWXPay
		openProductSpecificView
		addCard
		chooseCard
		openCard
	 * @return
	 */
	public static String generateConfigJson(String jsapi_ticket,boolean debug,String appId,String url,String... jsApiList){
		long timestamp = System.currentTimeMillis()/1000;
		String nonceStr = UUID.randomUUID().toString();
		String signature = generateConfigSignature(nonceStr, jsapi_ticket,timestamp+"",url);
		return new StringBuilder()
			.append("{")
			.append("debug:").append(debug).append(",")
			.append("appId:").append("'").append(appId).append("'").append(",")
			.append("timestamp:").append(timestamp).append(",")
			.append("nonceStr:").append("'").append(nonceStr).append("'").append(",")
			.append("signature:").append("'").append(signature).append("'").append(",")
			.append("jsApiList:").append(JsonUtil.toJSONString(jsApiList))
			.append("}").toString();
	}

	/**
	 * 生成微信支付JSON
	 * @param payPackage
	 * @param appid
	 * @param paternerKey
	 * @param paySignkey
	 * @return
	 */
	public static String generateChooseWXPayJson(PayPackage payPackage,
			String appid,
			String paternerKey,
			String paySignkey){
		Map<String, String> mapP = MapUtil.objectToMap(payPackage);
		String package_ = SignatureUtil.generatePackage(mapP, paternerKey);
		Map<String, String> map = new LinkedHashMap<String, String>();
		long timestamp = System.currentTimeMillis()/1000;
		String noncestr = UUID.randomUUID().toString();
		map.put("timestamp", timestamp+"");
		map.put("noncestr",noncestr);
		map.put("package",package_);
		map.put("appid",appid);
		String paySign = SignatureUtil.generatePaySign(map,paySignkey);
		map.put("paySign", paySign);
		map.remove("appid");
		return JsonUtil.toJSONString(map);
	}

}
