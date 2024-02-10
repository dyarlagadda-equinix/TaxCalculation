package com.img.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.img.dto.EmployeeDto;
import com.img.dto.EmployeeResponse;
import com.img.entity.EmployeeEntity;
import com.img.repository.EmployeeRepository;
import com.img.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	public EmployeeRepository employeeRepository ;
	
	@Override
	public EmployeeEntity saveEmployeDetails(EmployeeDto employeeDto) {
		log.info("Entered into saveEmployeDetails() of EmployeeServiceImpl.java");
		EmployeeEntity emp = new EmployeeEntity();
		emp.setEmployeeId(employeeDto.getEmployeeId()) ;
		emp.setFirstName(employeeDto.getFirstName()) ;
		emp.setLastName(employeeDto.getLastName());
		emp.setEmail(employeeDto.getEmail());
		emp.setPhoneNumber(employeeDto.getPhoneNumber());
		emp.setDoj(employeeDto.getDoj());
		emp.setSalary(employeeDto.getSalary());

		return employeeRepository.save(emp);
		
	}
	
	@Override
	public List<EmployeeResponse> getTaxCalulationForEmployes() {
		log.info("Entered into getTaxCalulationForEmployes() of EmployeeServiceImpl.java");
		
		List<EmployeeEntity> emps =employeeRepository.findAll();
		List<EmployeeResponse> calResp = new ArrayList();
		for(EmployeeEntity  emp:emps) {
			
			EmployeeResponse  empResponse = new EmployeeResponse();
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(emp.getDoj());
			
			LocalDate dateBefore = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		    LocalDate dateAfter = LocalDate.of(calendar.get(Calendar.YEAR)+1, Month.MARCH, 31);
		    
		    long noOfmonths = ChronoUnit.DAYS.between(dateBefore, dateAfter)/30;
			Double totalAnnualSalary = emp.getSalary()*noOfmonths ;
			
			Double tax  = 0.0;
			Double cessAmount=0.0;
			if(totalAnnualSalary<=250000) {
				 tax = 0.0;
			}else if(totalAnnualSalary>250000 && totalAnnualSalary<=500000) {
				 tax = (totalAnnualSalary-250000)*0.05;
			}else if(totalAnnualSalary>500000 && totalAnnualSalary<=1000000) {
				 tax = (250000)*0.05 + (totalAnnualSalary-500000)*0.1;
			}else {
				 tax = (250000)*0.05 + (500000)*0.1 + (totalAnnualSalary-1000000)*0.2;
			}
			
			if(totalAnnualSalary>2500000) {
				cessAmount = (totalAnnualSalary-2500000)*0.02 ;
			}
			empResponse.setEmpId(emp.getEmployeeId());
			empResponse.setFirstName(emp.getFirstName());
			empResponse.setLastName(emp.getLastName());
			empResponse.setYearlySalary(totalAnnualSalary);
			empResponse.setTax(tax);
			empResponse.setCessAmount(cessAmount);
			calResp.add(empResponse);
		}
		return calResp;
	}


}
