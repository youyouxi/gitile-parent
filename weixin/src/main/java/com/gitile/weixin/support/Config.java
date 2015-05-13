package com.gitile.weixin.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信公众号配置
 */
public class Config {

	private static final String configFile = "/weixin.properties";
	
	private String url;
	private String token;
	private String encodingAESKey;
	private String appid;
	private String appSecret;
	private String accessTokenServer;
	private String jsApiTicketServer;
	private static Config config = new Config();
	
	private Config(){
		Properties p = new Properties();
		InputStream inStream = this.getClass().getResourceAsStream(configFile);
		if(inStream == null){
			return;
		}
		try {
			p.load(inStream);
			this.url = p.getProperty("weixin.url").trim();
			this.encodingAESKey = p.getProperty("weixin.encodingaeskey").trim();
			this.token = p.getProperty("weixin.token").trim();
			this.appid = p.getProperty("weixin.appid").trim();
			this.appSecret = p.getProperty("weixin.appsecret").trim();
			this.accessTokenServer = p.getProperty("weixin.accessToken.server.class").trim();
			this.jsApiTicketServer = p.getProperty("weixin.ticket.jsapi.server.class").trim();
			inStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Config instance(){
		return config;
	}
	public String getToken() {
		return token;
	}
	public String getAppid() {
		return appid;
	}
	public String getAppSecret() {
		return appSecret;
	}

	public String getUrl() {
		return url;
	}

	public String getEncodingAESKey() {
		return encodingAESKey;
	}
	
	public String getAccessTokenServer(){
		return accessTokenServer;
	}

	public String getJsApiTicketServer() {
		return jsApiTicketServer;
	}

}