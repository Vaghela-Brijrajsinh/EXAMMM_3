
package com.example.twelth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.twelth.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

}

