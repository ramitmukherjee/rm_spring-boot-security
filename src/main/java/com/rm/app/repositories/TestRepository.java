package com.rm.app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rm.app.entities.Users;

public interface TestRepository extends CrudRepository<Users, String>{

}
