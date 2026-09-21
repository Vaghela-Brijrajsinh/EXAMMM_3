package com.example.sixth.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sixth.entity.Course;
import com.example.sixth.entity.Student;

import com.example.sixth.repository.CourseRepository;
import com.example.sixth.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;      


    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }     

    @PostMapping("/{id}/enroll/{courseId}")
    public Student enrollStudent(@PathVariable Integer id, @PathVariable Integer courseId) {
        Student student = studentRepository.findById(id).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (student == null || course == null) {
            return null;

        }
        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    // Get Student   
    // 
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }
    // Remove Course 
    //   

    @DeleteMapping("/{id}/unenroll/{courseId}")
    public String unenrollStudent(@PathVariable Integer id, @PathVariable Integer courseId) {
        Student student = studentRepository.findById(id).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        if (student == null || course == null) {
            return "Not Found";
        
        }student.getCourses().remove(course);
        studentRepository.save(student);
        return "Course Removed Successfully";
    }
}
