package com.bank.usersservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.usersservice.model.User;
import com.bank.usersservice.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		CustomUserDetails userDetails = null;
		if(user !=null)
		{
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
				}
		else {
			throw new UsernameNotFoundException("user not exits with the name" + username);
		}
		
	
		return userDetails;
	}

}