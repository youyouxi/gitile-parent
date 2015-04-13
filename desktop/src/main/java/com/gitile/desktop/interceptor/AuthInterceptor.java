package com.gitile.desktop.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gitile.core.auth.AuthUtils;
import com.gitile.core.utils.HttpUtils;
import com.gitile.core.utils.StringUtils;
import com.gitile.desktop.base.model.SysUser;

/**
 * 权限验证拦截器
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	protected static Set<String> noAuthPages = new HashSet<String>();
	
	static {
		logger.debug("开始加载地址。。。。。");
		noAuthPages.add("/");
		noAuthPages.add("/index");
		noAuthPages.add("/common/*");
		logger.debug("******结束加载地址******");
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String context = request.getContextPath();
		String uri = HttpUtils.buildRedirectUrl(context, request.getRequestURI());
		// 判断是否登录系统
		SysUser sessionUser = (SysUser)AuthUtils.getSessionUser(request);
		if (sessionUser != null) {
			request.setAttribute("sessionUser", sessionUser);
			// 过滤无需权限验证的请求
			if (!isAuthNeed(uri)) {
				return true;
			} else {
				return true;
			}
		} else {
			// ajax超时处理
			if (AuthUtils.isAjaxRequest(request)) {
				response.setHeader("sessionstatus", "timeout_user");// 在响应头设置session状态
			} else {
				String resUri = context + "/login?refurl=" + uri;
				if (StringUtils.isNotEmpty(request.getQueryString())) {
					resUri = resUri + "?" + request.getQueryString();
				}
				response.sendRedirect(resUri);
			}
			return false;
		}
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	protected boolean isAuthNeed(String uri) {
		for (String path : noAuthPages) {
			if (AuthUtils.isPermission(uri, path)) {
				return false;
			}
		}
		return true;
	}

}