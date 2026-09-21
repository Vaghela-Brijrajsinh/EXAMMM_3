package com.example.fourteenth.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fourteenth.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}