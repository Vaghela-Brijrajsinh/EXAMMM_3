package com.example.thirteenth.controller;

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

import com.example.thirteenth.entity.Customer;
import com.example.thirteenth.repository.CustomerRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerRepository repository;

    // Add Customer
    @PostMapping
    public Customer addCustomer(
            @Valid @RequestBody Customer customer) {

        return repository.save(customer);
    }

    // Display All Customers
    @GetMapping
    public List<Customer> getAllCustomers() {

        return repository.findAll();
    }

    // Display Customer By Id
    @GetMapping("/{id}")
    public Customer getCustomer(
            @PathVariable Integer id) {

        return repository.findById(id).orElse(null);
    }

    // Update Customer
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Integer id,
            @Valid @RequestBody Customer customer) {

        customer.setCustomerId(id);

        return repository.save(customer);
    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public String deleteCustomer(
            @PathVariable Integer id) {

        repository.deleteById(id);

        return "Customer Deleted Successfully";
    }
}