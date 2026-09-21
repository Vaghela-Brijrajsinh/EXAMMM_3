package com.example.third.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.third.entity.Employee;
import com.example.third.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository repository;

    // Add Employee
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PostMapping("/batch")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
        return repository.saveAll(employees);
    }

    // Get All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // Get Employees By Department
    @GetMapping("/department/{department}")
    public List<Employee> getDepartment(@PathVariable String department) {
        return repository.findByDepartment(department);
    }

    // Count Employees By Department
    @GetMapping("/count/{department}")
    public long countDepartment(@PathVariable String department) {
        return repository.countByDepartment(department);
    }

    // Get Employees With Salary Greater Than
    @GetMapping("/salary-above")
    public List<Employee> salaryAbove(@RequestParam double salary) {
        return repository.findBySalaryGreaterThan(salary);
    }

    // Get Employees Between Salary Range
    @GetMapping("/salary-range")
    public List<Employee> salaryRange(@RequestParam double min,
            @RequestParam double max) {
        return repository.findBySalaryRange(min, max);
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
