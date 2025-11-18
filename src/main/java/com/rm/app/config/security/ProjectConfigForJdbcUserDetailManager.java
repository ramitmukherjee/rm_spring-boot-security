package com.rm.app.config.security;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.rm.app.config.filters.CustomRequestValidationFilter;

@Configuration
public class ProjectConfigForJdbcUserDetailManager {

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {

        // String usersByUsernameQuery = "select username, password, enabled from <USERS_TABLE> where username = ?";
        // String authsByUserQuery = "select username, authority from <AUTHORITIES_TABLE> where username = ?";

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setEnableAuthorities(true);
        
        // userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        // userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        
        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity.httpBasic(Customizer.withDefaults());
        // Temporarily disable csrf to test POST requests
        httpSecurity.csrf(csrf -> csrf.disable());

        httpSecurity.addFilterBefore(new CustomRequestValidationFilter(), BasicAuthenticationFilter.class);
        
        return httpSecurity.build();
    }

}
