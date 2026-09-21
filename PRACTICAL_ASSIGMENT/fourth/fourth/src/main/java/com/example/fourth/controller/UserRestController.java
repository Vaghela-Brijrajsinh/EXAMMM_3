package com.example.fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fourth.entity.User;
import com.example.fourth.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserRepository repository;

    // Add User
    @PostMapping
    public User addUser(@RequestBody User user) {
        return repository.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Get User By ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {

        user.setUserId(id);
        return repository.save(user);

    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {

        repository.deleteById(id);
        return "User Deleted Successfully";
    }
}
