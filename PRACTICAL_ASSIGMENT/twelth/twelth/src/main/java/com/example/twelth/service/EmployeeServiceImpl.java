
package com.example.twelth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.twelth.dto.EmployeeDTO;
import com.example.twelth.entity.Employee;
import com.example.twelth.mapper.EmployeeMapper;
import com.example.twelth.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {

        Employee employee = EmployeeMapper.toEntity(dto);

        // Sensitive/internal fields
        employee.setSalary(50000);
        employee.setPassword("admin123");

        Employee savedEmployee = repository.save(employee);

        return EmployeeMapper.toDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> findAll() {

        List<Employee> employees = repository.findAll();

        List<EmployeeDTO> dtoList = new ArrayList<>();

        for (Employee employee : employees) {

            dtoList.add(EmployeeMapper.toDTO(employee));
        }

        return dtoList;
    }

    @Override
    public EmployeeDTO update(Integer id, EmployeeDTO dto) {

        Employee employee = repository.findById(id).orElse(null);

        if (employee == null) {
            return null;
        }

        employee.setEmpName(dto.getEmpName());
        employee.setDepartment(dto.getDepartment());

        Employee updatedEmployee = repository.save(employee);

        return EmployeeMapper.toDTO(updatedEmployee);
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);
    }
}

