package com.gitile.core.auth.cache;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}
	
	public User(String username) {
		this.username = username;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "username:"+username;
	}
    
}
