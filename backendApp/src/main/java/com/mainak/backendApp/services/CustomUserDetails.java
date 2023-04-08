package com.mainak.backendApp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mainak.backendApp.models.User;

public class CustomUserDetails implements UserDetails{

	private User user;
	private String email;
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public String getEmail() {
		return user.getEmail();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> role = new ArrayList<>();
		if(user.getRoles().equalsIgnoreCase("ROLE_ADMIN"))
			role.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		role.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return role;
	}
	
//	public String getRole() {
//		return user.getRoles(); 
//	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
