package com.example.fourteenth.service;


import org.springframework.stereotype.Service;

import com.example.fourteenth.entity.Customer;
import com.example.fourteenth.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}