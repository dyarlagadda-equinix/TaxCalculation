package com.img.service;

import java.util.List;

import com.img.dto.EmployeeDto;
import com.img.dto.EmployeeResponse;
import com.img.entity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity saveEmployeDetails(EmployeeDto employeeDto);
	public List<EmployeeResponse> getTaxCalulationForEmployes();

}
