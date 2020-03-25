package com.tutorial.springsecurityjpa.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tutorial.springsecurityjpa.entity.User;
import com.tutorial.springsecurityjpa.repository.UserRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user= repository.findByUsername(username);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found "+username));
		return user.map(MyUserDetails::new).get();
	}

}
