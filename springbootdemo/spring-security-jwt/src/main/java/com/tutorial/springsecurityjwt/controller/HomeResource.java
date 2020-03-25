package com.tutorial.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.springsecurityjwt.model.AutenticationRequest;
import com.tutorial.springsecurityjwt.model.AuthenticationResponse;
import com.tutorial.springsecurityjwt.util.JwtUtil;

@RestController
public class HomeResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailssService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World!!";
		
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AutenticationRequest authRequest) throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password");
		}
		
		final UserDetails userDetails=userDetailssService.loadUserByUsername(authRequest.getUserName());
		
		final String jwt=jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.status(HttpStatus.OK).body(new AuthenticationResponse(jwt));
	}

}
