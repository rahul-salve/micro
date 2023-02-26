package com.crudOperation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.entity.Employee;
import com.crudOperation.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
		String status=employeeService.save(employee);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Integer empId){
		Employee emp=employeeService.update(employee, empId);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer empId){
		Employee employee=employeeService.getById(empId);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployees=employeeService.getAllEmployee();
		return new ResponseEntity<>(allEmployees,HttpStatus.OK);
	}
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId){
		String status=employeeService.deleteById(empId);
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
}
