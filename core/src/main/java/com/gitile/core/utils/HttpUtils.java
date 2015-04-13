package com.gitile.core.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
	
	/**
	 * 组装重定向url
	 * @param context
	 * @param uri
	 * @return
	 */
	public static String buildRedirectUrl(String context, String uri) {
		if(StringUtils.isNotEmpty(context)&&!context.equals("/")) {
			return uri.replace(context, "");
		}
		return uri;
	}
	
	public static String reqForPost(String postUrl, String context) {
		try {
			URL url = new URL(postUrl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true，默认是false
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			//	设定请求的方法为"post"，默认为"get"
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setConnectTimeout(30000);
			OutputStreamWriter writer = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
			writer.write(context);
			writer.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			writer.close();
			in.close();
			return StringUtils.trimToEmpty(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String reqForGet(String getUrl) {
		
		try {
			URL url = new URL(getUrl);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			// 默认是false
			httpURLConnection.setDoOutput(false);
			//	设置是否从httpUrlConnection读入，默认是true
			httpURLConnection.setDoInput(true);
			//	设定请求的方法为"post"，默认为"get"
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setConnectTimeout(30000);
			BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
			
			return StringUtils.trimToEmpty(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
