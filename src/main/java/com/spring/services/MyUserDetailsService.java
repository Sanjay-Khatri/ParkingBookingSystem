package com.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.repositories.UsersRepositories;
import com.spring.entities.MyUserDetails;
import com.spring.entities.Users;

@Service
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	UsersRepositories usersRepositories;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> user = usersRepositories.findByUsername(username);
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Username:\t"+username+"\tis not found in database....");
		}
		
		MyUserDetails myUserDetail = new MyUserDetails(user.get());
		return myUserDetail;
	}
	
	

}
