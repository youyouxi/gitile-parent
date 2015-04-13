package com.gitile.desktop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitile.core.auth.AuthUtils;
import com.gitile.desktop.base.dto.SessionUser;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.service.UserService;

@Controller
public class CommonController {
	
	@Autowired
	private UserService userService;

	/**
	 * 获取用户安装的所有应用
	 */
	@RequestMapping(value = "/common/getUserApplicaions", method = RequestMethod.GET)
	@ResponseBody
	public List<SysApplication> getUserApplicaions(HttpServletRequest request, Model model) {
		SessionUser user = (SessionUser)AuthUtils.getSessionUser(request);
		return userService.findUserApplicationByRoleId(user.getRoleId());
	}
	
}