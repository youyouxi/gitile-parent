package com.gitile.desktop.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitile.core.auth.AuthUtils;
import com.gitile.core.bean.Ajax;
import com.gitile.desktop.base.service.UserService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ConfigurableCaptchaService configurableCaptchaService;
	
	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return index(request, model);
	}
	
	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		return "index.ftl";
	}
	
	/**
	 * 进入登录页
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model,
			@RequestParam(value="refurl", required=false) String refurl) {
		model.addAttribute("refurl", refurl);
		return "login.ftl";
	}
	
	/**
	 * 进入登录页2
	 */
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login2(HttpServletRequest request, Model model,
			@RequestParam(value="refurl", required=false) String refurl) {
		model.addAttribute("refurl", refurl);
		return "login2.ftl";
	}
	
	/**
	 * 退出系统
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		AuthUtils.clearnSessionUser(request);
		return "redirect:/login";
	}
	
	/**
	 * 登录验证
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Ajax doLogin(HttpServletRequest request, HttpServletResponse response, Model model, 
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			@RequestParam(value="checkCode", required=false) String checkcode) {
		Ajax ajax = new Ajax();
		try {
			// 登录验证
			int result = userService.login(request, username, password, checkcode);
			if(result==AuthUtils.LOGIN_SUCCESS) {
				ajax.setCode(Ajax.SUCCESS);
				ajax.setResult(result);
			} else {
				ajax.setCode(Ajax.FAILURE);
				ajax.setResult(result);
			}
		} catch (Exception e) {
			ajax.setCode(Ajax.ERROR);
			e.printStackTrace();
		}
		return ajax;
	}
	
	/**
	 * 生成登陆验证码
	 * @param request
	 * @param model
	 * @param response
	 */
	@RequestMapping(value = "/checkCodeImage", method = RequestMethod.GET)
	public void checkCodeImage(HttpServletRequest request, Model model,
			HttpServletResponse response) {
		OutputStream outputStream = null;
		try {
			response.setContentType("image/png");
			response.setHeader("cache", "no-cache");
			outputStream = response.getOutputStream();
			// 得到验证码对象,有验证码图片和验证码字符串
			Captcha captcha = configurableCaptchaService.getCaptcha();
			// 取得验证码字符串并存入Session
			String verifyCode = captcha.getChallenge();
			HttpSession session = request.getSession(true);
			session.setAttribute(AuthUtils.AUTH_CHECK_CODE, verifyCode);
			// 取得验证码图片并输出
			BufferedImage bufferedImage = captcha.getImage();
			ImageIO.write(bufferedImage, "png", outputStream);
			outputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 内部系统错误
	 * @return
	 */
	@RequestMapping(value = "/error/500")
	public String uncaughtException(HttpServletRequest request, Model model, Throwable exception) {
		Throwable ex = null;
		if (exception != null) {
			ex = exception;
		}
		if (request.getAttribute("javax.servlet.error.exception") != null) {
			ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
			model.addAttribute("msg", ex.getMessage());
		}
		//记录日志
		logger.error(ex.getMessage(), ex);
		return "error/500.ftl";
	}
	
	/**
	 * 资源不存在
	 * @return
	 */
	@RequestMapping(value = "/error/404")
	public String resourceNotFound(HttpServletRequest request, Model model) {
		return "error/404.ftl";
	}
	
	/**
	 * 没有权限
	 * @return
	 */
	@RequestMapping(value = "/error/403")
	public String notPermission(HttpServletRequest request, Model model) {
		return "error/403.ftl";
	}

}