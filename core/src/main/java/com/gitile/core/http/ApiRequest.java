package com.gitile.core.http;

public abstract class ApiRequest {
	
	private Long timestamp;
	
	private String clientKey;
	
	private String sign;
	
	public abstract Class<?> getResponseClazz();
	
	public abstract String getApiGroup();
	
	public abstract String getMethodName();
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

}
