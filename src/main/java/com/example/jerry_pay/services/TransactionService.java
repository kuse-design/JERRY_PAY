package com.example.jerry_pay.services;

import com.example.jerry_pay.data.repositories.TransactionRepository;

public class TransactionService {
    private final AccountService accountService;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;

    public TransactionService(AccountService accountService, TransactionRepository transactionRepository,
                              NotificationService notificationService){
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
        this.notificationService = notificationService;
    }
}
