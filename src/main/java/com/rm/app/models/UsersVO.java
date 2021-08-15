package com.rm.app.models;

import java.util.ArrayList;
import java.util.List;

import com.rm.app.entities.Authority;
import com.rm.app.entities.Users;

public class UsersVO {
	
	private String username;
	private String password;
	private Boolean enabled;
	private List<UserAuthorityVO> userAuthorities;
	
	public UsersVO() { }
	
	public UsersVO(String username, String password, Boolean enabled, List<UserAuthorityVO> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userAuthorities = authorities;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<UserAuthorityVO> getAuthorities() {
		return userAuthorities;
	}

	public void setAuthorities(List<UserAuthorityVO> authorities) {
		this.userAuthorities = authorities;
	}
	
	public static UsersVO toModel(Users users) {
		List<UserAuthorityVO> authoritiesVOs = new ArrayList<>();
		for (Authority authority: users.getAuthorities()) {
			authoritiesVOs.add(UserAuthorityVO.toModel(authority));
		}
		return new UsersVO(users.getUsername(), users.getPassword(), users.getEnabled(), authoritiesVOs);
	}
	
}
