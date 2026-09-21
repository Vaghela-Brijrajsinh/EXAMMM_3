package com.example.eleventh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eleventh.entity.Customer;
import com.example.eleventh.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> search(String city, int minAge) {
        return repository.findByCityAndAgeGreaterThanEqual(city, minAge);
    }

    @Override
    public Customer update(Integer id, Customer customer) {
        customer.setCustomerId(id);
        return repository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}