package com.first.first.repository;



import org.springframework.data.repository.CrudRepository;

import com.first.first.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
