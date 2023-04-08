package com.mainak.backendApp.models;

import java.sql.Date;

import com.mainak.backendApp.dto.EmployeeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "office_employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emp_id;
	
	@Embedded
	private Name name;

	private String email;
	private String address;
	private String designation;
	private double salary;
	private String password;
	private String roles;

	public Employee() {}
	
	public Employee(EmployeeDTO emp){
		this.email = emp.getEmail();
		this.address = emp.getAddress();
		this.designation = emp.getDesignation();
		this.salary = emp.getSalary();
		this.password = emp.getPassword();
		this.name = new Name(emp.getFirstName(),emp.getLastName());
		this.roles = emp.getRole();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
}
