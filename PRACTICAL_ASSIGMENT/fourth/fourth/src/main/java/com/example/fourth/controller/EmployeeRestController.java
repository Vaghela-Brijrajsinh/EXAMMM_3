package com.example.fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.fourth.entity.Employee;
import com.example.fourth.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees-passport")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository repository;

    // Add Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @RequestBody Employee employee) {

        employee.setEmpId(id);
        return repository.save(employee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Employee Deleted Successfully";
    }
}