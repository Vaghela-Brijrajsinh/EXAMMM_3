package com.example.fourth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.fourth.entity.Country;
import com.example.fourth.repository.CountryRepository;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    @Autowired
    private CountryRepository repository;

    // Add Country
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return repository.save(country);
    }

    // Get All Countries
    @GetMapping
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    // Get Country By ID
    @GetMapping("/{id}")
    public Country getCountry(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update Country
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Integer id,
                                 @RequestBody Country country) {

        country.setCountryId(id);
        return repository.save(country);
    }

    // Delete Country
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable Integer id) {
        repository.deleteById(id);
        return "Country Deleted Successfully";
    }
}