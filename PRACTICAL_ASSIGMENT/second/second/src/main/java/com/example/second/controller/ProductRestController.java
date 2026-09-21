package com.example.second.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.second.entity.Product;
import com.example.second.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductRepository repository;

    // Add Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // Add Multiple Products
    @PostMapping("/batch")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return repository.saveAll(products);
    }

    // Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Get Product By ID
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // Update Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @RequestBody Product product) {

        Product p = repository.findById(id).orElse(null);

        if (p != null) {
            p.setProductName(product.getProductName());
            p.setCategory(product.getCategory());
            p.setPrice(product.getPrice());
            p.setQuantity(product.getQuantity());

            return repository.save(p);
        }

        return null;
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        repository.deleteById(id);
        return "Product Deleted Successfully";
    }

    // Sort Products By Price
    @GetMapping("/sorted")
    public List<Product> sortProducts() {

        return repository.findAll(Sort.by("price"));
    }

    // Flush Data
    @PostMapping("/flush")
    public String flushData() {

        repository.flush();
        return "Data Flushed Successfully";
    }
}