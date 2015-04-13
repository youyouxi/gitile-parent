package com.gitile.desktop.base.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gitile.desktop.base.model.SysUser;
import com.gitile.desktop.base.model.SysUserProfile;

/**
 * 保存登录用户
 *
 */
public class SessionUser implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private Long id;// 用户id
	private String name;// 姓名
	private Short sex;// 性别
	private String username;// 用户名
	private String roleId;// 所属角色
	private Long deptId;// 所属部门
	private Long positionId;// 当前职位
	private String headPortrait;// 头像
	
	private List<String> rights;// 系统权限
	private Map<String, Object> params;// 扩展参数
	
	public SessionUser() {}
	public SessionUser(SysUser user, SysUserProfile profile) {
		this.id=user.getId();
		this.roleId = user.getRoleId();
		this.username = user.getUsername();
		
		this.name=profile.getName();
		this.sex = profile.getSex();
		this.deptId = profile.getDeptId();
		this.positionId = profile.getPositionId();
		this.headPortrait = profile.getHeadPortrait();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public List<String> getRights() {
		return rights;
	}
	public void setRights(List<String> rights) {
		this.rights = rights;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
