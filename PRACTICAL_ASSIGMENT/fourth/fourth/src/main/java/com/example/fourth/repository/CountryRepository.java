package com.example.fourth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fourth.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}