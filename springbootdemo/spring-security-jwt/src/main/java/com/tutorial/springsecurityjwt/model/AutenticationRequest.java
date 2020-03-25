package com.tutorial.springsecurityjwt.model;

public class AutenticationRequest {

	
	private String userName;
	private String password;
	
	public AutenticationRequest() {
		
	}
	
	public AutenticationRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
