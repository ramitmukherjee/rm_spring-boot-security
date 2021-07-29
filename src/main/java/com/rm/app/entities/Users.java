package com.rm.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This entity is meant to be used by Spring Security
 * @author 6078235
 *
 */
@Entity
@Table(name = "users")
public class Users {
	
	private String username;
	private String password;
	private Boolean enabled;
	
	@Id
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
	
	@Column(columnDefinition = "TINYINT(1)")
	public Boolean getEnabled() {
		return enabled;
	}
	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
