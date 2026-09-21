package com.example.eleventh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eleventh.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByCityAndAgeGreaterThanEqual(
            String city,
            int age
    );
}