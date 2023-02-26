package com.crudOperation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.entity.Employee;
import com.crudOperation.repo.EmpRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmpRepository empRepository;

	@Override
	public String save(Employee employee) {
		empRepository.save(employee);
		return "data inserted..";
	}

	@Override
	public Employee update(Employee emp,Integer empId) {
		Employee updatedEmp=new Employee();
		Optional<Employee> savedEmp=empRepository.findById(empId);
			BeanUtils.copyProperties(updatedEmp=savedEmp.get(),emp);
		   return updatedEmp=empRepository.save(emp);
	}

	@Override
	public Employee getById(Integer empId) {
		Optional<Employee> findbyId = empRepository.findById(empId);
		if (findbyId.isPresent()) {
			return findbyId.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepository.findAll();
	}

	@Override
	public String deleteById(Integer empId) {
		if (empRepository.existsById(empId)) {
			empRepository.deleteById(empId);
			return "Delete Success..";
		} else
			return "No Records found..";
	}

}
