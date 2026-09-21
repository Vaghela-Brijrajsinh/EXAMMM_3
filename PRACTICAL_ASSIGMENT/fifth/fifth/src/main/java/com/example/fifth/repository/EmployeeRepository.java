package com.example.fifth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fifth.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}