package com.example.eleventh.service;

import java.util.List;

import com.example.eleventh.entity.Customer;

public interface CustomerService {

    Customer create(Customer customer);

    Customer getById(Integer id);

    List<Customer> search(String city, int minAge);

    Customer update(Integer id, Customer customer);

    void delete(Integer id);
}