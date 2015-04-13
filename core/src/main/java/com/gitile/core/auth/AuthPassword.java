package com.gitile.core.auth;

/**
 * 密码加密信息
 */
public class AuthPassword {

	private String plainPassword;//明文密码
	private String password;//加密密码
	private String salt;//加密密码散列
	
	public AuthPassword() {}
	
	public AuthPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	
	public String getPlainPassword() {
		return plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
