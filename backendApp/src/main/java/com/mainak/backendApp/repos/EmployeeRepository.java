package com.mainak.backendApp.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mainak.backendApp.dto.EmployeeDTO;
import com.mainak.backendApp.models.Employee;
import com.mainak.backendApp.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Optional<Employee> findByEmail(String email);

	void save(EmployeeDTO empDetails);
	
	List<Employee> findAll();
	
	
}
