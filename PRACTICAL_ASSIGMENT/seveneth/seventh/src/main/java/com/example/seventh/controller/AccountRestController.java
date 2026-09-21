package com.example.seventh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.seventh.entity.Account;
import com.example.seventh.repository.AccountRepository;
import com.example.seventh.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountService service;

    // Create Account
    @PostMapping
    public Account addAccount(@RequestBody Account account) {

        return repository.save(account);
    }

    // Get Account by ID
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id) {

        return repository.findById(id).orElse(null);
    }

    // Get All Accounts
    @GetMapping
    public List<Account> getAll() {

        return repository.findAll();
    }

    // Transfer Money
    @PostMapping("/transfer")
    public String transferMoney(
            @RequestParam Integer fromId,
            @RequestParam Integer toId,
            @RequestParam double amount) {

        service.transferFunds(fromId, toId, amount);

        return "Amount Transferred Successfully";
    }

    // Update Account
    @PutMapping("/{id}")
    public Account updateAccount(
            @PathVariable Integer id,
            @RequestBody Account account) {

        Account existing = repository.findById(id).orElse(null);

        if (existing == null)
            return null;

        existing.setAccountHolder(account.getAccountHolder());

        return repository.save(existing);
    }

    // Delete Account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Integer id) {

        Account account = repository.findById(id).orElse(null);

        if (account == null)
            return "Account Not Found";

        if (account.getBalance() != 0)
            return "Account Cannot Be Deleted. Balance Must Be Zero.";

        repository.delete(account);

        return "Account Deleted Successfully";
    }
}