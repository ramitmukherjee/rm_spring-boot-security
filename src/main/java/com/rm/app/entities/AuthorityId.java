package com.rm.app.entities;

import java.io.Serializable;

public class AuthorityId implements Serializable {

	private static final long serialVersionUID = -7708605858758199405L;
	private String username;
	private String authority;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAuthority() {
		return authority;
	}
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
