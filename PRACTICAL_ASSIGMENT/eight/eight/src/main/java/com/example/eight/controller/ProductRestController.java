package com.example.eight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.eight.entity.Product;
import com.example.eight.repository.ProductRepository;

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

    // Update Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id,
                                 @RequestBody Product product) {

        product.setProductId(id);
        return repository.save(product);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {

        repository.deleteById(id);
        return "Product Deleted Successfully";
    }

    // Pagination and Sorting
   @GetMapping("/page")
public Page<Product> getProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "price") String sortBy) {

    System.out.println("sortBy = " + sortBy);

    Pageable pageable = PageRequest.of(
            page,
            size,
            Sort.by(sortBy));

    return repository.findAll(pageable);
}
}