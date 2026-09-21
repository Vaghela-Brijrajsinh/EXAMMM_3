package com.example.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.second.entity.Product;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    /*
     * Repository Hierarchy:
     *
     * CrudRepository:
     * save()
     * findAll()
     * findById()
     * deleteById()
     *
     * PagingAndSortingRepository:
     * findAll(Sort)
     * findAll(Pageable)
     *
     * JpaRepository:
     * saveAll()
     * flush()
     * saveAndFlush()
     */
}