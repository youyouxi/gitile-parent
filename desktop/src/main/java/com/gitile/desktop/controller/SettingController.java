package com.gitile.desktop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitile.desktop.base.service.UserService;

@Controller
public class SettingController {
	
	@Autowired
	private UserService userService;

	/**
	 * 系统设置
	 */
	@RequestMapping(value = "/setting/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		return "setting/index.ftl";
	}
	
}