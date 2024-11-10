package com.sathya.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.entity.Employee;

import com.sathya.service.EmployeeServiceImp;




@CrossOrigin("*")
@RestController

public class EmployeeController {

	@Autowired
	private EmployeeServiceImp service;
	
	@PostMapping("/save")
	public String saveEmployeeData(@RequestBody Employee employee)
	{
		Employee saveEployeeData=service.save(employee);
		String message=null;
		if( saveEployeeData!=null)
		{
			message="Data Saved SuccessFully";
		}
		else
		{
			message="Data is Failed";
		}
		return message;
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmplyee(){ 
		List<Employee>getAllEmplyee=service.getAll();
		return getAllEmplyee;
		
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		service.delete(id);
	}
	
	 @PutMapping("/update/{id}")
	    public Employee update(@RequestBody Employee employee, @PathVariable Long id) {
	        Employee updatedEmployee = service.update(employee, id);
	        return updatedEmployee;
	 }
	   @GetMapping("/getone/{id}")
	    public Employee getOneEmployee(@PathVariable Long id)
	    {
		   Employee employee= service.getEmployee(id);
	    	return employee;
	    }
	       
	    
	 
	
}
