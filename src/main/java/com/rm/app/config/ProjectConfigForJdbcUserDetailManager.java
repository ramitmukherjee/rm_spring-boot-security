package com.rm.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectConfigForJdbcUserDetailManager {

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {

        // String usersByUsernameQuery = "select username, password, enabled from <USERS_TABLE> where username = ?";
        // String authsByUserQuery = "select username, authority from <AUTHORITIES_TABLE> where username = ?";

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        
        // userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        // userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
