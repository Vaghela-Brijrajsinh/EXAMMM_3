package com.example.sixth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sixth.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}