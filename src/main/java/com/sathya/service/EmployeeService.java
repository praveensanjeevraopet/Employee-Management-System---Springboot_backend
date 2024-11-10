package com.sathya.service;

import java.util.List;


import com.sathya.entity.Employee;




public interface EmployeeService {
	
	public Employee save(Employee employee);
	public List<Employee> getAll();
	public Employee update(Employee employee,Long id);
	public void delete(Long id);
	public Employee getEmployee(Long id);
	
}


