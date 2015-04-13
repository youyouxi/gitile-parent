package com.gitile.core.http;

import com.gitile.core.utils.HttpUtils;
import com.gitile.core.utils.JsonMapper;

public class ApiClient {

	private final static JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	private String serverUrl;
	private String clientKey;
	private String secretKey;
	
	public ApiClient(String serverUrl, String clientKey, String secretKey) {
		this.serverUrl = serverUrl;
		this.clientKey = clientKey;
		this.secretKey = secretKey;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends ApiResponse> T execute(ApiRequest request) {
		long start = System.currentTimeMillis();
		request.setTimestamp(start);
		request.setClientKey(clientKey);
		String noSignParam = jsonMapper.toJson(request);
		request.setSign(ApiSign.buildSign(serverUrl, clientKey, secretKey, noSignParam));
		StringBuilder serverUrlSB = new StringBuilder(serverUrl);
		if (!serverUrl.endsWith("/")) {
			serverUrlSB.append("/");
		}
		serverUrlSB.append(request.getApiGroup()).append("/").append(request.getMethodName());
		String result = HttpUtils.reqForPost(serverUrlSB.toString(), "param=" + jsonMapper.toJson(request));
		return (T) jsonMapper.fromJson(result, request.getResponseClazz());
	}
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

}