
package com.example.fourteenth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fourteenth.entity.Employee;
import com.example.fourteenth.exception.ResourceNotFoundException;
import com.example.fourteenth.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // GET ALL EMPLOYEES
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // GET EMPLOYEE BY ID
    public Employee getEmployeeById(Integer id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );
    }

    // CREATE EMPLOYEE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // UPDATE EMPLOYEE
    public Employee updateEmployee(Integer id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        existingEmployee.setEmpName(employee.getEmpName());

        return employeeRepository.save(existingEmployee);
    }

    // DELETE EMPLOYEE
    public void deleteEmployee(Integer id) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        employeeRepository.delete(existingEmployee);
    }
}

