package com.example.tenth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tenth.entity.Product;
import com.example.tenth.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductService service;

    @PostMapping
    public Product save(@RequestBody Product product) {

        return service.save(product);
    }

    @GetMapping
    public List<Product> getAll() {

        return service.getAll();
    }

@GetMapping("/{id}")
public String getById(@PathVariable Integer id) {

    Product product = service.getById(id);

    if (product == null) {
        return "Product Not Found";
    }

    return product.toString();
}

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id,
                          @RequestBody Product product) {

        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        return service.delete(id);
    }

}