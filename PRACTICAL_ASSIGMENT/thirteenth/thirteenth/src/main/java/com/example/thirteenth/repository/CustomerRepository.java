package com.example.thirteenth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.thirteenth.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer, Integer> {

}