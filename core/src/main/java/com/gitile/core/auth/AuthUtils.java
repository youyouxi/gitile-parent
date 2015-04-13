package com.gitile.core.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gitile.core.utils.StringUtils;

public class AuthUtils {
	
	public final static String SESSION_KEY="authorizesession";// 保存session中关键字
	public final static String REQUEST_KEY="sessionUser";// 保存在request中关键字
	
	public final static String AUTH_CHECK_CODE="checkCode";// 保存在session中验证码

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	/** 登录状态错误码 **/
	public final static int LOGIN_FAILURE = 0;// 用户名或密码不正确
	public final static int LOGIN_SUCCESS = 1;// 登录成功
	public final static int LOGIN_USERNAME_OR_PASSWORD_EMPTY = 2;// 登录时，用户名或密码为空
	public final static int LOGIN_USER_NOT_FOUND = 3;// 登录时，登录用户不存在
	public final static int LOGIN_ACCOUNT_UNUSED = 4;// 账号不可用
	public final static int LOGIN_ACCOUNT_FREEZE = 5;// 账号冻结不可用
	public final static int LOGIN_IS_LOGIN_OTHER_PLACE= 6;// 账号在其他地方登录
	public final static int LOGIN_CHECK_CODE_ERROR= 7;// 验证码不正确
	
	public static void setSessionUser(HttpServletRequest request, Object user){
		request.getSession().setAttribute(SESSION_KEY, user);
	}
	public static void setSessionUser(HttpServletRequest request, String sessionKey, Object user){
		request.getSession().setAttribute(sessionKey, user);
	}

	public static Object getSsoSessionUser(HttpServletRequest request, String tickkey){
		if(StringUtils.isEmpty(tickkey)){
			clearnSessionUser(request, SESSION_KEY);
			return null;
		}
		return request.getSession().getAttribute(SESSION_KEY);
	}
	public static Object getSsoSessionUser(HttpServletRequest request, String sessionKey, String tickkey){
		if(StringUtils.isEmpty(tickkey)){
			clearnSessionUser(request, sessionKey);
			return null;
		}
		return request.getSession().getAttribute(sessionKey);
	}
	
	public static Object getSessionUser(HttpServletRequest request){
		return request.getSession().getAttribute(SESSION_KEY);
	}
	public static Object getSessionUser(HttpServletRequest request, String sessionKey){
		return request.getSession().getAttribute(sessionKey);
	}
	
	public static void clearnSessionUser(HttpServletRequest request){
		request.getSession().removeAttribute(SESSION_KEY);
	}
	public static void clearnSessionUser(HttpServletRequest request, String sessionKey){
		request.getSession().removeAttribute(sessionKey);
	}

	/**
	 * 判断ip是否符合规则
	 * 
	 * @param ip
	 * @param settings
	 * @return
	 */
	public static boolean isPermissionIp(String ip, String settings) {
		String[] rules = settings.split(",");
		if (StringUtils.isEmpty(ip)) {
			return false;
		}
		for (String rule : rules) {
			if (isPermission(ip, rule)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否符合规则
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean isPermission(String from, String to) {
		if (from == null || to == null) {
			return false;
		}
		if (to.endsWith("*")) {
			if (from.startsWith(to.substring(0, to.length() - 1))) {
				return true;
			}
		} else {
			if (from.equals(to)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		if(request.getHeader("x-requested-with")!=null
				&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证密码是否正确
	 * @param loginUser
	 * @return
	 */
	public static boolean validatePassword(AuthPassword passwd) {
		byte[] salt = EncodePwd.decodeHex(passwd.getSalt());
		byte[] hashPassword = DigestsPwd.sha1(passwd.getPlainPassword().getBytes(),
				salt, HASH_INTERATIONS);
		if (EncodePwd.encodeHex(hashPassword).equals(passwd.getPassword())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 管理员信息设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	public static AuthPassword entryptPassword(String plainPassword) {
		AuthPassword passwd = new AuthPassword();
		passwd.setPlainPassword(plainPassword);
		byte[] salt = DigestsPwd.generateSalt(SALT_SIZE);
		passwd.setSalt(EncodePwd.encodeHex(salt));
		byte[] hashPassword = DigestsPwd.sha1(passwd.getPlainPassword().getBytes(),
				salt, 1024);
		passwd.setPassword(EncodePwd.encodeHex(hashPassword));
		return passwd;
	}

	/**
	 * 设置cookie
	 * 
	 * @param response: 从外部传进来的response对象,不可以为null
	 * @param key: cookie的健
	 * @param value: cookie的值
	 * @param domain: cookie所在的域,可以为null,为null时按时默认的域存储
	 * @param maxAge: cookie最大时效,以秒为单位,为null时表示不设置最大时效,按照浏览器进程结束
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, String domain, Integer maxAge) {
		Cookie c = new Cookie(key, value);
		if (domain != null && domain.length() > 0) {
			c.setDomain(domain);
		}
		if (maxAge != null) {
			c.setMaxAge(maxAge);
		}
		c.setPath("/");
		response.addCookie(c);
	}

	/**
	 * 从cookie中得到值
	 * 
	 * @param request
	 * @param key:cookie名称
	 * @param domain:域名
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String key, String domain) {
		if (StringUtils.isEmpty(key)||StringUtils.isEmpty(domain)) {
			return null;
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (key.equals(c.getName())&&domain.equals(c.getDomain())) {
					return c.getValue();
				}
			}
		}
		return null;
	}

}