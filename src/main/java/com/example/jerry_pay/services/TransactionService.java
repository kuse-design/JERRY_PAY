package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Transaction;
import com.example.jerry_pay.data.models.TransactionDirection;
import com.example.jerry_pay.data.repositories.TransactionRepository;
import com.example.jerry_pay.exception.InsufficientBalanceException;
import com.example.jerry_pay.exception.InvalidPinException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
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

    public void deposit(String accountNumber, BigDecimal amount){
        Account account = accountService.findAccount(accountNumber);

        accountService.validateAccount(account);
        account.setBalance(account.getBalance().add(amount));
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType(TransactionDirection.CREDIT);
        transaction.setTimestamp(LocalDateTime.now());;
        transactionRepository.save(transaction);
        notificationService.sendCreditAlert(account, amount);
    }

    public void withdraw (String accountNumber,String pin, BigDecimal amount){
        Account account = accountService.findAccount(accountNumber);

        accountService.validateAccount(account);
        if (!account.getUser().getPin().equals(pin)) {
            throw new InvalidPinException("Invalid PIN");
        }
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient funds");
        }

        account.setBalance(account.getBalance().subtract(amount));
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setType(TransactionDirection.DEBIT);
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);
        notificationService.sendDebitAlert(account, amount);
    }
}

