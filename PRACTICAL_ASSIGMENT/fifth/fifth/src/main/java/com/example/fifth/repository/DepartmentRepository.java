package com.example.fifth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fifth.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}