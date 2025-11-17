// package com.rm.app.controllers;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.rm.app.repositories.UserRepository;
// import com.rm.app.entities.UserEO;
// import com.rm.app.models.SecurityUser;

// @RequestMapping("/users")
// @RestController
// public class UserController {
	
// 	@Autowired
// 	UserRepository userRepository;
	
// 	@GetMapping
// 	public Iterable<SecurityUser> getAllUsers() {
// 		Iterable<UserEO> usersIterable = userRepository.findAll();
// 		List<SecurityUser> securityUsers = new ArrayList<>();
// 		for(UserEO u: usersIterable) {
// 			securityUsers.add(new SecurityUser(u));
// 		}
// 		return securityUsers;
// 	}

// }
