package com.rm.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class ProjectConfigBasic {

    /*

    // Defining UserDetailsService bean to override the default Spring Security config

    @Bean
    UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("bill")
            .password("1234")
            .authorities("read")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    */

    // It is mandatory to Define a PasswordEncoder as well along with a UserDetailsService
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Defining SecurityFilterChain to override the default Spring Security config
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());

        // We can also define UserDetailsService and PasswordEncoder in the SecurityFilterChain
        // instead of defining separate beans for them

        UserDetails user = User.withUsername("bill")
            .password("0123")
            .authorities("read")
            .build();

        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user);

        httpSecurity.userDetailsService(userDetailsService);
        
        return httpSecurity.build();
    }
    
}
