package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.*;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}