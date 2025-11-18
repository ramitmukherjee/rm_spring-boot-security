package com.rm.app.config.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rm.app.models.DummyUser;
import com.rm.app.service.CustomInMemoryUserDetailsService;

// @Configuration
public class ProjectConfigForCustomInMemoryUserDetailsService {

    @Bean
    UserDetailsService userDetailsService() {

        DummyUser d1 = new DummyUser("dummy", "dummy", "read");
        List<UserDetails> users = List.of(d1);
        return new CustomInMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    
}
