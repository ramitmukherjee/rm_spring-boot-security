package com.rm.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rm.app.repositories.UserRepository;
import com.rm.app.entities.UserEO;
import com.rm.app.models.SecurityUser;
import com.rm.app.models.UserVO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

    @Autowired
    UserDetailsService userDetailsService;
	
	@GetMapping
	public Iterable<SecurityUser> getAllUsers() {
		Iterable<UserEO> usersIterable = userRepository.findAll();
		List<SecurityUser> securityUsers = new ArrayList<>();
		for(UserEO u: usersIterable) {
			securityUsers.add(new SecurityUser(u));
		}
		return securityUsers;
	}

    @PostMapping()
    public UserVO createUser(@RequestBody UserVO userVO) {
        if(userDetailsService instanceof JdbcUserDetailsManager) {
            JdbcUserDetailsManager jdbcUserDetailsManager = (JdbcUserDetailsManager) userDetailsService;
            jdbcUserDetailsManager.createUser(userVO.toSecurityUser());
        }
        return userVO;
    }
    
    @DeleteMapping("/{username}")
    public String deleteUser(@PathVariable String username) {
        if(userDetailsService instanceof JdbcUserDetailsManager) {
            JdbcUserDetailsManager jdbcUserDetailsManager = (JdbcUserDetailsManager) userDetailsService;
            jdbcUserDetailsManager.deleteUser(username);
        }        
        return username + " deleted.";
    }

}
