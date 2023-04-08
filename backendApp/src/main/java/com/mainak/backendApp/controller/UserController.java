package com.mainak.backendApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mainak.backendApp.dto.EmployeeDTO;
import com.mainak.backendApp.dto.LoginSuccefulDTO;
import com.mainak.backendApp.dto.LoginUserDTO;
import com.mainak.backendApp.models.Employee;
import com.mainak.backendApp.models.Role;
import com.mainak.backendApp.repos.EmployeeRepository;
import com.mainak.backendApp.services.AddUserService;
import com.mainak.backendApp.services.CustomUserDetails;
import com.mainak.backendApp.services.CustomUserDetailsService;
import com.mainak.backendApp.services.LoginService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	private CustomUserDetailsService userService;
	@Autowired
	private AddUserService addUserService;
	
	@PostMapping("/loginBackend")
	public LoginSuccefulDTO loginBackend(@RequestBody LoginUserDTO userDetails) {
		return loginService.login(userDetails);
	}
	@PostMapping("/addUser")
	public String addUser(@RequestBody EmployeeDTO empDetails){
		return addUserService.addUser(empDetails);
	}
	@GetMapping("/getAllUsers")
	public List<Employee> getAllUsers(){
		return addUserService.getallUsers();
	}

	@GetMapping("/getUser/{employeeId}")
	public Optional<Employee> getUser(@PathVariable("employeeId") Integer user_id){
		return addUserService.getUser(user_id);
	}
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") Integer user_id) {
		addUserService.deleteUser(user_id);
	}	
	
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles() {
		return addUserService.getAllRoles();
	}
}
