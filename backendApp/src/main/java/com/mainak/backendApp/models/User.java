package com.mainak.backendApp.models;

import com.mainak.backendApp.dto.EmployeeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="login_user_details")
public class User{
	
	@Id
	@Column
	private int user_id;
	
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String roles;

	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name="fk_emp_id")
	private Employee employee;

	public User() {}
	
	public User(EmployeeDTO emp) {
		this.username = "EMP"+"_"+emp.getFirstName()+"_"+emp.getLastName();
		this.password = emp.getPassword();
		this.email = emp.getEmail();
		this.roles = emp.getRole();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		//employee.setUser(this);
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
