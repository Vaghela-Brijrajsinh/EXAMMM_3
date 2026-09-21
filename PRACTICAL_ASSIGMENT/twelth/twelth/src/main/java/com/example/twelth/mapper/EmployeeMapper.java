
package com.example.twelth.mapper;

import com.example.twelth.dto.EmployeeDTO;
import com.example.twelth.entity.Employee;

public class EmployeeMapper {

    // Entity -> DTO
    public static EmployeeDTO toDTO(Employee employee) {

        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmpId(employee.getEmpId());
        dto.setEmpName(employee.getEmpName());
        dto.setDepartment(employee.getDepartment());

        return dto;
    }

    // DTO -> Entity
    public static Employee toEntity(EmployeeDTO dto) {

        Employee employee = new Employee();

        employee.setEmpId(dto.getEmpId());
        employee.setEmpName(dto.getEmpName());
        employee.setDepartment(dto.getDepartment());

        return employee;
    }
}

