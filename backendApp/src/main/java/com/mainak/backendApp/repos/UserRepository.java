package com.mainak.backendApp.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;	
import org.springframework.stereotype.Repository;


import com.mainak.backendApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	User findByUsername(String username);

	User findByEmail(String username);

	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByEmailAndPasswordAndUsername(String email, String password, String username);
}
