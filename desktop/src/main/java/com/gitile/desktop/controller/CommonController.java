package com.gitile.desktop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitile.core.auth.AuthPassword;
import com.gitile.core.auth.AuthUtils;
import com.gitile.core.bean.Ajax;
import com.gitile.desktop.base.dto.SessionUser;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysUser;
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
	
	/**
	 * 使用帮助
	 */
	@RequestMapping(value = "/common/help", method = RequestMethod.GET)
	public String help(HttpServletRequest request, Model model) {
		return "common/help.ftl";
	}
	
	/**
	 * 设置背景图片
	 */
	@RequestMapping(value = "/common/backgroud", method = RequestMethod.GET)
	public String backgroud(HttpServletRequest request, Model model) {
		return "common/backgroud.ftl";
	}
	
	/**
	 * 个人设置
	 */
	@RequestMapping(value = "/common/profile", method = RequestMethod.GET)
	public String profile(HttpServletRequest request, Model model) {
		return "common/profile.ftl";
	}
	
	/**
	 * 关于我们
	 */
	@RequestMapping(value = "/common/aboutus", method = RequestMethod.GET)
	public String aboutus(HttpServletRequest request, Model model) {
		return "common/aboutus.ftl";
	}
	
	/**
	 * 上传文件
	 */
	@RequestMapping(value = "/common/upload", method = RequestMethod.GET)
	public String upload(HttpServletRequest request, Model model) {
		return "common/upload.ftl";
	}
	
	/**
	 * 修改用户密码信息
	 * @return
	 */
	@RequestMapping(value = "/common/changepwd", method = RequestMethod.POST)
	@ResponseBody
	public Ajax changepwd(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("oldpwd") String oldpwd, 
			@RequestParam("newpwd") String newpwd) {
		Ajax ajax = new Ajax();
		try {
			SessionUser sessionUser = (SessionUser)AuthUtils.getSessionUser(request);
			SysUser user = userService.findUser(sessionUser.getId());
			AuthPassword passwd = new AuthPassword();
			passwd.setPassword(user.getPassword());
			passwd.setSalt(user.getSalt());
			passwd.setPlainPassword(oldpwd);
			if(AuthUtils.validatePassword(passwd)) {
				SysUser update = new SysUser();
				update.setId(user.getId());
				update.setPassword(passwd.getPassword());
				update.setSalt(passwd.getSalt());
				boolean result = userService.updateUser(update);
				if(result) {
					ajax.setCode(Ajax.SUCCESS);
				} else {
					ajax.setCode(Ajax.FAILURE);
				}
			} else {
				ajax.setCode(Ajax.FAILURE);
				ajax.setResult(2);
			}
		} catch (Exception e) {
			ajax.setCode(Ajax.ERROR);
			e.printStackTrace();
		}
		return ajax;
	}
	
}