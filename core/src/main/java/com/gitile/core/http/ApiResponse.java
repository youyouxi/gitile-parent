package com.gitile.core.http;

public class ApiResponse {

	public static final Integer SUCCESS = 1; // 调用成功
	public static final Integer FAIL = -300; // 调用失败
	public static final Integer UNLOGIN = -301; // 未登录
	public static final Integer UNKNOWNERROR = -302; // 未知错误
	public static final Integer NOAUTHORIZE = -303; // 授权不存在
	public static final Integer TIMEINVALID = -304; // timestamp已过期
	public static final Integer SIGNERROR = -305; // sign错误
	
	private Integer code;

	private String text;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 调用成功
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		if (SUCCESS == code) {
			return true;
		}
		return false;
	}

	/**
	 * 调用失败
	 * 
	 * @return
	 */
	public boolean isFail() {
		if (FAIL == code) {
			return true;
		}
		return false;
	}
	
	/**
	 * 未知错误
	 * 
	 * @return
	 */
	public boolean isUnknownError() {
		if (UNKNOWNERROR == code) {
			return true;
		}
		return false;
	}

	/**
	 * 授权不存在
	 * 
	 * @return
	 */
	public boolean isNoAuthorize() {
		if (NOAUTHORIZE == code) {
			return true;
		}
		return false;
	}

	/**
	 * 时间无效
	 * 
	 * @return
	 */
	public boolean isTimeInvalid() {
		if (TIMEINVALID == code) {
			return true;
		}
		return false;
	}

	/**
	 * sign不存在
	 * 
	 * @return
	 */
	public boolean isSignError() {
		if (SIGNERROR == code) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否登录
	 * 
	 * @return
	 */
	public boolean isUnLogin() {
		if (UNLOGIN == code) {
			return true;
		}
		return false;
	}

}
