package com.example.tenth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tenth.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}