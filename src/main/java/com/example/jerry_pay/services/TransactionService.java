package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Transaction;
import com.example.jerry_pay.data.models.TransactionType;
import com.example.jerry_pay.data.repositories.TransactionRepository;

import java.math.BigDecimal;

public class TransactionService {
    private final AccountService accountService;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;

    public TransactionService(AccountService accountService, TransactionRepos
    }

    public void deposit(String accountNumber, BigDecimal amount){
        Account account = accountService.findAccount(accountNumber);
        account.setBalance(account.getBalance().add(amount));
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType(TransactionType.CREDIT);
        transaction.setTimestamp(timestamp);
    }
}
