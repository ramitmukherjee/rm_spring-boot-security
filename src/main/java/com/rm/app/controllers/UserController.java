package com.rm.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rm.app.entities.Users;
import com.rm.app.models.UsersVO;
import com.rm.app.repositories.UserRepository;

@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public Iterable<UsersVO> getAllUsers() {
		Iterable<Users> usersIterable = userRepository.findAll();
		List<UsersVO> usersVOs = new ArrayList<>();
		for(Users u: usersIterable) {
			usersVOs.add(UsersVO.toModel(u));
		}
		return usersVOs;
	}

}
