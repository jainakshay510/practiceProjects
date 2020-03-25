package com.tutorial.springsecurityldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResourceController {

	@GetMapping("/")
	public String index() {
		return "Home page";
	}
}
