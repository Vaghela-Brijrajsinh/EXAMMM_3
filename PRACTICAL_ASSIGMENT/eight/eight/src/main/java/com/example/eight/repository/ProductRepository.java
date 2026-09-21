package com.example.eight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eight.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {

   
}