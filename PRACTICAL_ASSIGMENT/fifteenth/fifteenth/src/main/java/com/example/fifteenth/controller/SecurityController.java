package com.example.fifteenth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fifteenth.model.SecureData;

@RestController
@RequestMapping("/api")
public class SecurityController {

    private final List<SecureData> dataList = new ArrayList<>();

    // Used to automatically generate IDs
    private int nextId = 1;

    // =========================================================
    // PUBLIC API
    // =========================================================
    @GetMapping("/public/data")
    public String publicData() {

        return "This is Public Data";
    }

    // =========================================================
    // SECURE GET - GET ALL DATA
    // =========================================================
    @GetMapping("/secure/data")
    public ResponseEntity<List<SecureData>> getData() {

        return ResponseEntity.ok(dataList);
    }

    // =========================================================
    // SECURE GET - GET DATA BY ID
    // =========================================================
    @GetMapping("/secure/data/{id}")
    public ResponseEntity<SecureData> getDataById(
            @PathVariable Integer id) {

        for (SecureData data : dataList) {

            if (data.getId().equals(id)) {

                return ResponseEntity.ok(data);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // =========================================================
    // SECURE POST - ADD DATA
    // =========================================================
    @PostMapping("/secure/data")
    public ResponseEntity<SecureData> addData(
            @RequestBody SecureData data) {

        // Automatically generate ID
        data.setId(nextId++);

        // Add object to list
        dataList.add(data);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(data);
    }

    // =========================================================
    // SECURE PUT - UPDATE DATA
    // =========================================================
    @PutMapping("/secure/data/{id}")
    public ResponseEntity<SecureData> updateData(
            @PathVariable Integer id,
            @RequestBody SecureData data) {

        for (SecureData d : dataList) {

            if (d.getId().equals(id)) {

                d.setText(data.getText());

                return ResponseEntity.ok(d);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // =========================================================
    // SECURE DELETE - DELETE DATA
    // =========================================================
    @DeleteMapping("/secure/data/{id}")
    public ResponseEntity<String> deleteData(
            @PathVariable Integer id) {

        boolean removed = dataList.removeIf(
                d -> d.getId().equals(id)
        );

        if (removed) {
            return ResponseEntity.ok("Data deleted successfully");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Data not found");
    }
}
