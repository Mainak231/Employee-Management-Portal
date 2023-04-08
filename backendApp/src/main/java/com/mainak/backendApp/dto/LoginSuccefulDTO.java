package com.mainak.backendApp.dto;

public class LoginSuccefulDTO {

	public String message;
	public String username;
    public String role;
    public int id;

	public LoginSuccefulDTO() {}
	
	public LoginSuccefulDTO(String message,String username,String role,int id) {
		this.message = message;
		this.username = username;
		this.role = role;
		this.id = id;
	}
}
