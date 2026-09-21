package com.example.tenth.service;

import java.util.List;

import com.example.tenth.entity.Product;

public interface ProductService {

    Product save(Product product);

    List<Product> getAll();

    Product getById(Integer id);

    Product update(Integer id, Product product);

    String delete(Integer id);

}