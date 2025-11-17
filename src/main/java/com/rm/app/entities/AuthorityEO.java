package com.rm.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthorityEO {

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	private String username;
	private String authority;

	@Id
	public String getUsername() {
		return username;
	}

	public String getAuthority() {
		return authority;
	}

}
