package com.bank.usersservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.usersservice.model.User;

public interface UserRepository extends MongoRepository<User, Integer>{
	User findByUsername(String username);
}
