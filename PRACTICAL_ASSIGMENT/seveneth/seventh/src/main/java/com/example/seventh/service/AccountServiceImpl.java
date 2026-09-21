package com.example.seventh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.seventh.entity.Account;
import com.example.seventh.exception.AccountNotFoundException;
import com.example.seventh.exception.InsufficientBalanceException;
import com.example.seventh.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    @Transactional
    public void transferFunds(int fromId,
                              int toId,
                              double amount) {

        Account fromAccount = repository.findById(fromId).orElse(null);

        Account toAccount = repository.findById(toId).orElse(null);

        if (fromAccount == null || toAccount == null) {
            throw new AccountNotFoundException("Account Not Found");
        }

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }

        fromAccount.setBalance(
                fromAccount.getBalance() - amount);

        toAccount.setBalance(
                toAccount.getBalance() + amount);

        repository.save(fromAccount);
        repository.save(toAccount);
    }
}