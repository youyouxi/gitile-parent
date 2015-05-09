package com.gitile.weixin.bean;

/**
 * 二维码 ticket
 *
 */
public class QrcodeTicket extends BaseResult{
	
	private String ticket;
	
	private Integer expire_seconds;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(Integer expireSeconds) {
		expire_seconds = expireSeconds;
	}
	
	
}
