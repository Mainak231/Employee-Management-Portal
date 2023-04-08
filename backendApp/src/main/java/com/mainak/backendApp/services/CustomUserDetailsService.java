package com.mainak.backendApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mainak.backendApp.models.User;
import com.mainak.backendApp.repos.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		CustomUserDetails userDetails = null;
		
		if(user!=null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
			System.out.println(userDetails.getAuthorities());
		}
		else {
			throw new UsernameNotFoundException("User not found with name : "+username);
		}
		return userDetails;
	}

}
