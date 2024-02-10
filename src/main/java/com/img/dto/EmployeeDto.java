package com.img.dto;

import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;


public class EmployeeDto {
	
	@NotBlank(message="EmployeeId is mandatory")
	Long employeeId ;
	
	@NotBlank(message="FirstName is mandatory")
	String firstName ;
	
	@NotBlank(message="LastName is mandatory")
	String lastName;
	
	@NotBlank(message="Email is mandatory")
	String email;
	
	@NotBlank(message="PhoneNumber is mandatory")
	Set<String> phoneNumber;
	
	@NotBlank(message="Date of Join is mandatory")
	Date doj;
	
	@NotBlank(message="Salary is mandatory")
	Double salary;

	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Set<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	

}
