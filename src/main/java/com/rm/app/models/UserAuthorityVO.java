package com.rm.app.models;

import com.rm.app.entities.Authority;

public class UserAuthorityVO {

	private String authority;

	public UserAuthorityVO() { }
	
	public UserAuthorityVO(String authority) {
		this.authority = authority;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public static UserAuthorityVO toModel(Authority authority) {
		return new UserAuthorityVO(authority.getAuthority());
	}

}
