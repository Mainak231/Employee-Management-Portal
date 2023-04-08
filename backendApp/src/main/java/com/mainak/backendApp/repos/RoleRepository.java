package com.mainak.backendApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mainak.backendApp.models.Employee;
import com.mainak.backendApp.models.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

	List<Role> findAll();
	
}
