package com.rm.app.models;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rm.app.entities.UserEO;

public class SecurityUser implements UserDetails {

    private final UserEO userEO;

    public SecurityUser(UserEO userEO) {
        this.userEO = userEO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEO.getAuthorities()
                .stream()
                .map(authorityEO -> new SimpleGrantedAuthority(authorityEO.getAuthority()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userEO.getPassword();
    }

    @Override
    public String getUsername() {
        return userEO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEO.getEnabled();
    }
    
}
