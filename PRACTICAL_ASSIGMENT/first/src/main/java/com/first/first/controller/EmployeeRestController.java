package com.first.first.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.first.first.entity.Employee;
import com.first.first.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // POST - Save Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
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