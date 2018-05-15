package com.niit.employeeskillsmaprest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillsmapper.dao.EmployeeDetails;
import com.niit.skillsmapper.model.EmployeeModel;

@RestController

public class EmployeeController 
{
	@Autowired
	EmployeeDetails employeeDetails;
	
	@RequestMapping("/")
	public String showIndex()
	{
		return "index";
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel emp)
	{
		boolean value=employeeDetails.registerEmployee(emp);
		/*if(value==true)
		{
			emp.setErrorCode("200");
			emp.setErrorMsg("registration done ");
		}
		else
		{

			emp.setErrorCode("300");
			emp.setErrorMsg("error in registration ");
		}
*/		return new ResponseEntity<EmployeeModel>(emp,HttpStatus.OK);
	}
	

}
