package com.example.sixteenth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sixteenth.entity.AppUser;
import com.example.sixteenth.repository.AppUserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder) {

        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<AppUser> register(
            @RequestBody AppUser appUser) {

        appUser.setPassword(
                passwordEncoder.encode(
                        appUser.getPassword()));

        AppUser savedUser
                = appUserRepository.save(appUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    // Update authenticated user's profile
    @PutMapping("/profile")
    public ResponseEntity<AppUser> updateProfile(
            @RequestBody AppUser updatedUser,
            Authentication authentication) {

        String currentUsername
                = authentication.getName();

        AppUser existingUser
                = appUserRepository
                        .findByUsername(currentUsername)
                        .orElseThrow(()
                                -> new RuntimeException(
                                "User not found"));

        if (updatedUser.getUsername() != null
                && !updatedUser.getUsername().isBlank()) {

            existingUser.setUsername(
                    updatedUser.getUsername());
        }

        if (updatedUser.getRole() != null
                && !updatedUser.getRole().isBlank()) {

            existingUser.setRole(
                    updatedUser.getRole());
        }

        AppUser savedUser
                = appUserRepository.save(existingUser);

        return ResponseEntity.ok(savedUser);
    }

    // Delete authenticated user's account
    // Delete user
    @DeleteMapping("/register/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable Integer id,
            Authentication authentication) {

        AppUser user = appUserRepository
                .findById(id)
                .orElseThrow(()
                        -> new RuntimeException("User not found"));

        if (!user.getUsername()
                .equals(authentication.getName())) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("You can delete only your own account");
        }

        appUserRepository.delete(user);

        return ResponseEntity
                .ok("User deleted successfully");
    }
}
