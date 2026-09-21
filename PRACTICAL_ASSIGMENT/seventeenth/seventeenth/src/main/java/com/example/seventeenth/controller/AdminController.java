package com.example.seventeenth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    // GET - ADMIN ONLY
    @GetMapping("/data")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdminData() {

        return ResponseEntity.ok(
                "Admin data accessed successfully.");
    }

    // POST - ADMIN ONLY
    @PostMapping("/data")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> createAdminData(
            @RequestBody String data) {

        return ResponseEntity
                .status(201)
                .body("Admin data created: " + data);
    }

    // PUT - ADMIN ONLY
    @PutMapping("/data/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateAdminData(
            @PathVariable Integer id,
            @RequestBody String data) {

        return ResponseEntity.ok(
                "Admin data " + id +
                " updated: " + data);
    }

    // DELETE - ADMIN ONLY
    @DeleteMapping("/data/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAdminData(
            @PathVariable Integer id) {

        return ResponseEntity.noContent().build();
    }
}