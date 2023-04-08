package com.mainak.backendApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainak.backendApp.dto.LoginSuccefulDTO;
import com.mainak.backendApp.dto.LoginUserDTO;
import com.mainak.backendApp.models.User;
import com.mainak.backendApp.repos.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepo;
	
	public LoginSuccefulDTO login(LoginUserDTO userDetails) {
		
		Optional<User> user = userRepo.findByEmailAndPassword(userDetails.getEmail(),userDetails.getPassword());
		User user_obj = userRepo.findByEmail(userDetails.getEmail());
		
		if(user.isPresent()) {
	
			return new LoginSuccefulDTO("User Authenticated",user_obj.getUsername(),user_obj.getRoles(),user_obj.getUser_id());
		}
		return new LoginSuccefulDTO("User not Authenticated",user_obj.getUsername(),user_obj.getRoles(),user_obj.getUser_id());
	}
}
