package com.crudOperation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudOperation.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {



}
