package com.crudOperation.service;

import java.util.List;

import com.crudOperation.entity.Employee;

public interface EmployeeService {
	public String save(Employee employee);

	public Employee update(Employee emp,Integer empId);

	public Employee getById(Integer empId);

	public List<Employee> getAllEmployee();

	public String deleteById(Integer empId);
}
