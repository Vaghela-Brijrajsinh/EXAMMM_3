package com.example.fifth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.fifth.entity.*;
import com.example.fifth.repository.*;



@RestController
@RequestMapping("/api/departments")
public class DepartmentRestController {

    @Autowired
    private DepartmentRepository repository;

    // Add Department with Employees
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {

        for (Employee employee : department.getEmployees()) {
            employee.setDepartment(department);
        }

        return repository.save(department);
    }

    // Get Department by ID
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Integer id) {

        return repository.findById(id).orElse(null);
    }

    // Get Employees of a Department
    @GetMapping("/{id}/employees")
    public List<Employee> getEmployees(@PathVariable Integer id) {

        Department department = repository.findById(id).orElse(null);

        if (department == null) {
            return null;
        }

        return department.getEmployees();
    }

    // Update Employee of Department
    @PutMapping("/{deptId}/employees/{empId}")
    public Department updateEmployee(@PathVariable Integer deptId,
                                     @PathVariable Integer empId,
                                     @RequestBody Employee updatedEmployee) {

        Department department = repository.findById(deptId).orElse(null);

        if (department == null) {
            return null;
        }

        for (Employee employee : department.getEmployees()) {

            if (employee.getEmpId().equals(empId)) {
                employee.setEmpName(updatedEmployee.getEmpName());
                employee.setSalary(updatedEmployee.getSalary());
                break;
            }
        }

        return repository.save(department);
    }

    // Delete Employee from Department
    @DeleteMapping("/{deptId}/employees/{empId}")
    public String deleteEmployee(@PathVariable Integer deptId,
                                 @PathVariable Integer empId) {

        Department department = repository.findById(deptId).orElse(null);

        if (department == null) {
            return "Department Not Found";
        }

        department.getEmployees().removeIf(employee -> employee.getEmpId().equals(empId));

        repository.save(department);

        return "Employee Deleted Successfully";
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Integer id) {

        repository.deleteById(id);

        return "Department Deleted Successfully";
    }
}