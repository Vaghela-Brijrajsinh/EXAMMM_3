
package com.example.sixth.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.sixth.entity.Course;
import com.example.sixth.entity.Student;
import com.example.sixth.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {

    @Autowired
    private CourseRepository repository;

    // Add Course
    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return repository.save(course);
    }

    // Get Students of Course
    @GetMapping("/{id}/students")
    public Set<Student> getStudents(@PathVariable Integer id) {

        Course course = repository.findById(id).orElse(null);

        if (course == null)
            return null;

        return course.getStudents();
    }

    // Update Course
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id,
                               @RequestBody Course course) {

        course.setCourseId(id);
        return repository.save(course);
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id) {

        repository.deleteById(id);
        return "Course Deleted Successfully";
    }
}