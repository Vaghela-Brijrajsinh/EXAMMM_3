package com.example.nineteenth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    private final Map<Long, Map<String, Object>> notes = new HashMap<>();
    private long nextId = 1;

    // GET User Profile
    @GetMapping("/profile")
    public Map<String, Object> getUserProfile(
            @AuthenticationPrincipal OAuth2User principal) {

        return Map.of(
                "name", principal.getAttribute("name"),
                "email", principal.getAttribute("email")
        );
    }

    // POST Create Note
    @PostMapping("/notes")
    public ResponseEntity<Map<String, Object>> createNote(
            @RequestBody Map<String, String> request,
            @AuthenticationPrincipal OAuth2User principal) {

        Map<String, Object> note = new HashMap<>();

        note.put("id", nextId);
        note.put("text", request.get("text"));
        note.put("user", principal.getAttribute("email"));

        notes.put(nextId, note);

        nextId++;

        return ResponseEntity.status(201).body(note);
    }

    // PUT Update Note
    @PutMapping("/notes/{id}")
    public ResponseEntity<Map<String, Object>> updateNote(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        Map<String, Object> note = notes.get(id);

        if (note == null) {
            return ResponseEntity.notFound().build();
        }

        note.put("text", request.get("text"));

        return ResponseEntity.ok(note);
    }

    // DELETE Delete Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNote(
            @PathVariable Long id) {

        if (!notes.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        notes.remove(id);

        return ResponseEntity.noContent().build();
    }
}
