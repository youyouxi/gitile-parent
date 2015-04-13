package com.gitile.desktop.base.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitile.core.auth.AuthPassword;
import com.gitile.core.auth.AuthUtils;
import com.gitile.core.utils.DateUtils;
import com.gitile.core.utils.StringUtils;
import com.gitile.desktop.base.dao.SysRoleDao;
import com.gitile.desktop.base.dao.SysUserDao;
import com.gitile.desktop.base.dao.SysUserProfileDao;
import com.gitile.desktop.base.dto.SessionUser;
import com.gitile.desktop.base.model.SysApplication;
import com.gitile.desktop.base.model.SysRole;
import com.gitile.desktop.base.model.SysUser;
import com.gitile.desktop.base.model.SysUserExample;
import com.gitile.desktop.base.model.SysUserProfile;
import com.gitile.desktop.base.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserDao<SysUser> sysUserDao;
	
	@Autowired
	private SysUserProfileDao<SysUserProfile> sysUserProfileDao;
	
	@Autowired
	private SysRoleDao<SysRole> sysRoleDao;

	@Override
	public int login(HttpServletRequest request, String username, String password, String checkcode) {
		if(validateCheckCode(request, checkcode)) {
			if (StringUtils.isNotEmpty(username)
					&& StringUtils.isNotEmpty(password)) {
				SysUserExample example = new SysUserExample();
				example.createCriteria().andUsernameEqualTo(username);
				SysUser user = sysUserDao.selectByExample(example);
				if (user != null) {
					boolean canUsed = false;
					if (user.getStatus() == 1) {
						canUsed = true;
					} else if (user.getStatus() == 2) {
						// 账号冻结，登录出现三次错误后，锁定账号，30分钟后解封
						long minutes = DateUtils.minuteBetween(user.getLastLoginTime(), new Date());
						if (minutes > 30) {
							SysUser updateUser = new SysUser();
							updateUser.setId(user.getId());
							updateUser.setStatus((short)1);
							updateUser.setFailureLoginCount(0);
							Integer result = sysUserDao.updateSelective(updateUser);
							if (result > 0) {
								canUsed = true;
							}
						}
						if(!canUsed) {
							return AuthUtils.LOGIN_ACCOUNT_FREEZE;
						}
					}
					HttpSession session = request.getSession();
					if (canUsed) {
						AuthPassword passwd = new AuthPassword();
						passwd.setPassword(user.getPassword());
						passwd.setSalt(user.getSalt());
						passwd.setPlainPassword(password);
						if (AuthUtils.validatePassword(passwd)) {
							SysUserProfile profile = findUserProfile(user.getId());
							if(profile!=null) {
								// 设置session
								SessionUser sessionUser = new SessionUser(user, profile);
								sessionUser.setRights(findUserRights(user.getRoleId()));
								AuthUtils.setSessionUser(request, sessionUser);
								SysUser updateUser = new SysUser();
								updateUser.setId(user.getId());
								updateUser.setFailureLoginCount(0);
								updateUser.setLastLoginTime(new Date());
								// 删除验证码
								session.setAttribute(AuthUtils.AUTH_CHECK_CODE, null);
								sysUserDao.updateSelective(updateUser);
								return AuthUtils.LOGIN_SUCCESS;
							} else {
								return AuthUtils.LOGIN_USER_NOT_FOUND;
							}
						} else {
							SysUser updateUser = new SysUser();
							updateUser.setId(user.getId());
							if (user.getFailureLoginCount() == 3) {
								// 当错误次数大于3时，显示验证码
								session.setAttribute(AuthUtils.AUTH_CHECK_CODE, 1001);
							}
							if (user.getFailureLoginCount() > 3) {
								// 大于5次锁定账号
								updateUser.setStatus((short)2);
							}
							updateUser.setFailureLoginCount((user.getFailureLoginCount() + 1));
							sysUserDao.updateSelective(updateUser);
							return AuthUtils.LOGIN_FAILURE;
						}
					} else {
						return AuthUtils.LOGIN_ACCOUNT_UNUSED;
					}
				} else {
					return AuthUtils.LOGIN_USER_NOT_FOUND;
				}
			} else {
				return AuthUtils.LOGIN_USERNAME_OR_PASSWORD_EMPTY;
			}
		} else {
			return AuthUtils.LOGIN_CHECK_CODE_ERROR;
		}
	}
	
	/**
	 * 获取用户扩展信息
	 * @param id
	 * @return
	 */
	private SysUserProfile findUserProfile(Long id) {
		return sysUserProfileDao.selectById(id);
	}
	
	/**
	 * 获取用户可访问权限信息
	 * @param roleId
	 * @return
	 */
	private List<String> findUserRights(String roleId) {
		return sysRoleDao.selectRightsByRoleId(roleId);
	}
	
	/**
	 * 验证验证码是否正确
	 * @param request
	 * @param checkcode
	 * @return
	 */
	private boolean validateCheckCode(HttpServletRequest request, String checkcode) {
		Object verifyCode = request.getSession().getAttribute(AuthUtils.AUTH_CHECK_CODE);
		if(verifyCode!=null) {
			return checkcode.equalsIgnoreCase(String.valueOf(verifyCode));
		}
		return true;
	}

	@Override
	public List<SysApplication> findUserApplicationByRoleId(String roleId) {
		return sysRoleDao.selectApplicationByRoleId(roleId);
	}

}
