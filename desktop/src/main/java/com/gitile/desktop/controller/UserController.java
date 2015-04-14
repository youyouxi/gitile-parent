package com.gitile.desktop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitile.desktop.base.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 我的文件
	 */
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		return "user/index.ftl";
	}
	
	/**
	 * 我的文件
	 */
	@RequestMapping(value = "/user/download", method = RequestMethod.GET)
	public String download(HttpServletRequest request, Model model) {
		return "user/index.ftl";
	}
	
	/**
	 * 共享文件
	 */
	@RequestMapping(value = "/user/share", method = RequestMethod.GET)
	public String share(HttpServletRequest request, Model model) {
		return "user/index.ftl";
	}
	
	

}