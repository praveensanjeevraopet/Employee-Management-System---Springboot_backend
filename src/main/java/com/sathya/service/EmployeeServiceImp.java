package com.sathya.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.entity.Employee;

import com.sathya.repository.EmployeeRepository;



@Service

public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee save(Employee employee) {
	
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> getAll=repo.findAll();
		return getAll ;
	}

	@Override
	public Employee update(Employee employee, Long id) {
	    Employee oldRecord = repo.findById(id).get();
	    oldRecord.setFirstName(employee.getFirstName());
	    oldRecord.setLastName(employee.getLastName());
	    oldRecord.setEmail(employee.getEmail());
	    return repo.save(oldRecord);
	}


	@Override
	public void delete(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee getEmployee(Long id) {
		Employee get=repo.findById(id).get();
		return get;
	}

	


	
	

	

	

}
