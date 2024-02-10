package com.img.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="employee")
@Entity
public class EmployeeEntity implements Serializable {

	@Id
	Long employeeId ;
	
	@Column(name="firstName")
	String firstName ;
	
	@Column(name="lastName")
	String lastName;
	
	@Column(name="email")
	String email;
	
	@Column(name="phoneNumber")
	Set<String> phoneNumber;
	
	@Column(name="doj")
	Date doj;
	
	@Column(name="salary")
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
