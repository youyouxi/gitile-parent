package com.gitile.desktop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gitile.core.auth.AuthUtils;
import com.gitile.desktop.base.dto.SessionUser;
import com.gitile.desktop.base.model.SysApplicationRight;
import com.gitile.desktop.base.service.UserService;

@Controller
public class SettingController {
	
	@Autowired
	private UserService userService;

	/**
	 * 获取左边菜单
	 * @param model
	 */
	private void initLeftMenu(HttpServletRequest request, Model model) {
		SessionUser sessionUser = (SessionUser)AuthUtils.getSessionUser(request);
		List<SysApplicationRight> menus = userService.findUserApplicationMenu(sessionUser.getRoleId(), 2L);
		model.addAttribute("menus", menus);
	}

	/**
	 * 系统设置
	 */
	@RequestMapping(value = "/setting/user", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		initLeftMenu(request, model);
		return "setting/user.ftl";
	}

	



	
	
	
}