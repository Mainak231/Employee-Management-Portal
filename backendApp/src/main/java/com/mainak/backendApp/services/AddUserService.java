package com.mainak.backendApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainak.backendApp.dto.EmployeeDTO;
import com.mainak.backendApp.models.Employee;
import com.mainak.backendApp.models.Name;
import com.mainak.backendApp.models.Role;
import com.mainak.backendApp.models.User;
import com.mainak.backendApp.repos.EmployeeRepository;
import com.mainak.backendApp.repos.RoleRepository;
import com.mainak.backendApp.repos.UserRepository;

@Service
public class AddUserService {

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	
	public String addUser(EmployeeDTO empDetails) {
		Optional<Employee> emailEntry = empRepo.findByEmail(empDetails.getEmail());
		Name name = new Name(empDetails.getFirstName(),empDetails.getLastName());
		
		Employee emp = new Employee(empDetails);
		User user = new User(empDetails);
				
		if(!emailEntry.isPresent() && emp != null) {
			user.setEmployee(emp);
			empRepo.save(emp);
			userRepo.save(user);
			return "succesful";
		}
		return "faliure";
	}
	
	public List<Employee> getallUsers(){
		List<Employee> employees = new ArrayList<>();
		empRepo.findAll().forEach(emp -> employees.add(emp));
		return employees;
	}

	public List<Role> getAllRoles(){
		List<Role> roles = new ArrayList<>();
		roleRepo.findAll().forEach(role -> roles.add(role));
		return roles;
	}
	public void deleteUser(Integer user_id) {
		userRepo.deleteById(user_id);
		empRepo.deleteById(user_id);
	}
	
	public void updateUser(Integer user_id) {
		
	}

	public Optional<Employee> getUser(Integer user_id) {
		return empRepo.findById(user_id);
	}
}
