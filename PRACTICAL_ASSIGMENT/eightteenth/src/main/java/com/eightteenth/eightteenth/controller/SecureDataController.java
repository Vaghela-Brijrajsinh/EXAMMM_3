package com.eightteenth.eightteenth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secure")
public class SecureDataController {

    @GetMapping("/data")
    public ResponseEntity<String> getSecureData() {

        return ResponseEntity.ok(
                "Protected resource data");
    }

    @PostMapping("/data")
    public ResponseEntity<String> createSecureData(
            @RequestBody String data) {

        return ResponseEntity
                .status(201)
                .body("Created: " + data);
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<String> updateSecureData(
            @PathVariable Integer id,
            @RequestBody String data) {

        return ResponseEntity.ok(
                "Updated " + id + ": " + data);
    }

    @DeleteMapping("/data/{id}")
    public ResponseEntity<Void> deleteSecureData(
            @PathVariable Integer id) {

        return ResponseEntity.noContent().build();
    }
}