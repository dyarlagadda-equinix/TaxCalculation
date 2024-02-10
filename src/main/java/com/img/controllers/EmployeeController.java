package com.img.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.img.dto.EmployeeDto;
import com.img.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployeDetails(@Valid @RequestBody EmployeeDto employeeDto){
		log.info("Entered into saveEmployeDetails() of EmployeeController.java");
		return new ResponseEntity<>(employeeService.saveEmployeDetails(employeeDto),HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/calculateEmployeeTax")
	public ResponseEntity<?> getTaxCalulationForEmployes() {
		log.info("Entered into getTaxCalulationForEmployes() of EmployeeController.java");
		return new ResponseEntity<>(employeeService.getTaxCalulationForEmployes(),HttpStatus.OK);
	}
}
