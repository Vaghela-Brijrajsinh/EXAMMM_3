package com.example.twelth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.twelth.dto.EmployeeDTO;
import com.example.twelth.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // POST - Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> save(
            @RequestBody EmployeeDTO dto) {

        EmployeeDTO savedEmployee = service.save(dto);

        return new ResponseEntity<>(
                savedEmployee,
                HttpStatus.OK
        );
    }

    // GET - Get All Employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {

        List<EmployeeDTO> employees = service.findAll();

        return ResponseEntity.ok(employees);
    }

    // PUT - Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(
            @PathVariable Integer id,
            @RequestBody EmployeeDTO dto) {

        EmployeeDTO updatedEmployee
                = service.update(id, dto);

        if (updatedEmployee == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    // DELETE - Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
