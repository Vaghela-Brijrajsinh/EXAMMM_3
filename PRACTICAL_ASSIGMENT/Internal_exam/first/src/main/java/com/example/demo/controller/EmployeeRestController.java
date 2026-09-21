
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;


import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	// GET - Get All Employees
	@GetMapping
	public Iterable<Employee> getAllEmployees() {
	return employeeRepository.findAll();
	}
	// GET - Get Employee By ID
	@GetMapping("/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
	return employeeRepository.findById(id);
	}
	// PUT - Update Employee
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id,
	@RequestBody Employee employee) {
	employee.setEmpId(id);
	return employeeRepository.save(employee);
	}
	// DELETE - Delete Employee
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
	employeeRepository.deleteById(id);
	return "Employee Deleted Successfully";
	}
}