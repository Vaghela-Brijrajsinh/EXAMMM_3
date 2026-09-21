package com.example.sixth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sixth.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}