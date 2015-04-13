package com.gitile.desktop.interceptor;

import java.util.HashSet;
import java.util.List;
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
import com.gitile.desktop.base.dto.SessionUser;

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
		SessionUser sessionUser = (SessionUser)AuthUtils.getSessionUser(request);
		if (sessionUser != null) {
			request.setAttribute("sessionUser", sessionUser);
			// 过滤无需权限验证的请求
			if (!isAuthNeed(uri)) {
				return true;
			} else {
				// 根据权限信息，进行权限验证
				List<String> rights = sessionUser.getRights();
				if(rights!=null&&rights.size()>0) {
					for (String right : rights) {
						if (AuthUtils.isPermission(uri, right)) {
							return true;
						}
					}
				}
				// ajax超时处理
				if (AuthUtils.isAjaxRequest(request)) {
					response.setHeader("authstatus", "noauth_user");// 在响应头设置session状态
				} else {
					response.sendRedirect(context + "/error/403");
				}
				return false;
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