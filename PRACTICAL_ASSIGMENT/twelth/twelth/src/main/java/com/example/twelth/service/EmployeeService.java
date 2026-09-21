
package com.example.twelth.service;

import java.util.List;

import com.example.twelth.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO dto);

    List<EmployeeDTO> findAll();

    EmployeeDTO update(Integer id, EmployeeDTO dto);

    void delete(Integer id);
}

