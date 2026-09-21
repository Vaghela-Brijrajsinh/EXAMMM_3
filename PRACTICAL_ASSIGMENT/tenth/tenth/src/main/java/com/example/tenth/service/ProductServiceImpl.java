package com.example.tenth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tenth.entity.Product;
import com.example.tenth.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Integer id, Product product) {

        product.setProductId(id);

        return repository.save(product);
    }

    @Override
    public String delete(Integer id) {

        repository.deleteById(id);

        return "Product Deleted Successfully";
    }


}