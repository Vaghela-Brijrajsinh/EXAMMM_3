package com.example.sixteenth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecurityController {

    @GetMapping("/data")
    public String getData() {

        return "This is Secure Data";
    }
}