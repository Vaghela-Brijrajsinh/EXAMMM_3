package com.example.fourteenth.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fourteenth.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}