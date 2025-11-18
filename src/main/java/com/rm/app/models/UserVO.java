package com.rm.app.models;

import java.util.ArrayList;
import java.util.List;

import com.rm.app.entities.AuthorityEO;
import com.rm.app.entities.UserEO;

public class UserVO {

    private String username;
    private String password;
    private boolean enabled;
    private List<String> authorities;

    public UserVO() {

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
    
    public SecurityUser toSecurityUser() {
        UserEO userEO = new UserEO();
        userEO.setUsername(username);
        userEO.setPassword(password);
        userEO.setEnabled(enabled);

        List<AuthorityEO> auths = new ArrayList<>();

        for(String authority: authorities) {
            AuthorityEO auth = new AuthorityEO();
            auth.setUsername(username);
            auth.setAuthority(authority);
            auths.add(auth);
        }      

        userEO.setAuthorities(auths);

        return new SecurityUser(userEO);
    }
    
}
