package com.example.fourth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fourth.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}