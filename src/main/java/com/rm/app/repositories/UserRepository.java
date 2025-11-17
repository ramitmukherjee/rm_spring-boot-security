package com.rm.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rm.app.entities.UserEO;

@Repository
public interface UserRepository extends CrudRepository<UserEO, String> {

}
