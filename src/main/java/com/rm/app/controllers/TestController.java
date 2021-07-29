package com.rm.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rm.app.entities.Users;
import com.rm.app.repositories.TestRepository;

@RequestMapping("/test")
@RestController
public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	@GetMapping
	public Iterable<Users> test() {
		return testRepository.findAll();
	}

}
