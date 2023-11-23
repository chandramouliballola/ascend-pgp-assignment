package com.bank.usersservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.usersservice.model.User;
import com.bank.usersservice.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("admin/addUser")
	public String saveBook(@RequestBody User user) {
		//System.out.println("Inside Admin Controller");
		String pwd= user.getPassword();
		 String encrptedPwd = passwordEncoder.encode(pwd);
		 user.setPassword(encrptedPwd);
		 //System.out.println("Hello this is the encrypted password : "+encrptedPwd);
//		 userRepository.save(user);
		 repository.save(user);
		return "Added user with id :" + user.getId();
	}
	
	@GetMapping("get/allUsers")
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	@GetMapping("get/findUser/{id}")
	public Optional<User> getUsersById(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("admin/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		repository.deleteById(id);
		return "User Account deleted with id :" + id;
	}

}
