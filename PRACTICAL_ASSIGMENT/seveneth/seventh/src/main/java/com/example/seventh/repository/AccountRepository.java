package com.example.seventh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seventh.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}