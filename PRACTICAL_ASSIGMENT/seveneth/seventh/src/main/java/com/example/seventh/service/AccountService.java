package com.example.seventh.service;

import com.example.seventh.entity.Account;

public interface AccountService {

    Account updateAccount(int id, Account account);

    void transferFunds(int fromId, int toId, double amount);

}
