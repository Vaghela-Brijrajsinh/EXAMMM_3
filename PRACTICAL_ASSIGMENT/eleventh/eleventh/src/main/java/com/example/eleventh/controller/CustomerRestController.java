package com.example.eleventh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eleventh.entity.Customer;
import com.example.eleventh.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    // POST - @RequestBody
    @PostMapping
    public Customer create(@RequestBody Customer customer) {

        return service.create(customer);
    }

    // GET - @PathVariable
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id) {

        return service.getById(id);
    }

    // GET - @RequestParam
    @GetMapping("/search")
    public List<Customer> search(
            @RequestParam String city,
            @RequestParam(defaultValue = "0") int minAge) {

        return service.search(city, minAge);
    }

    // PUT - @PathVariable + @RequestBody
    @PutMapping("/{id}")
    public Customer update(
            @PathVariable Integer id,
            @RequestBody Customer customer) {

        return service.update(id, customer);
    }

    // DELETE - @PathVariable
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        service.delete(id);

        return "Customer Deleted Successfully";
    }
}