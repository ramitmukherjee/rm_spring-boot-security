package com.rm.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This entity is meant to be used by Spring Security
 * @author 6078235
 *
 */
@Entity
@Table(name = "users")
public class UserEO {
	
	private String username;
	private String password;
	private Boolean enabled;
	private List<AuthorityEO> authorities;
	
	@Id
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	@OneToMany(mappedBy = "username")
	public List<AuthorityEO> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<AuthorityEO> authorities) {
		this.authorities = authorities;
	}
	
}
