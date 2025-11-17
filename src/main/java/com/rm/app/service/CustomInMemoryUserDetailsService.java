package com.rm.app.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomInMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;

    public CustomInMemoryUserDetailsService(List<UserDetails> users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails =  users.stream()
            .filter(u -> username.equals(u.getUsername()))
            .findFirst()
            .orElseThrow(
                () -> new UsernameNotFoundException("User not found" + username)
            );
        return userDetails;
    }

    
    
}
