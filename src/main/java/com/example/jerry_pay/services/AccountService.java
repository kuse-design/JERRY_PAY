package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.repositories.AccountRepository;
import com.example.jerry_pay.dtos.request.CreateAccountRequest;
import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.exception.AccountNotFoundException;
import com.example.jerry_pay.utils.AccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountNumberGenerator generator;

    public AccountService(AccountRepository accountRepository,
                          AccountNumberGenerator generator) {
        this.accountRepository = accountRepository;
        this.generator = generator;
    }

    public AccountResponse createAccount(CreateAccountRequest request) {

        Account account = new Account();
        account.setaccountName(request.getaccountName());
        account.setBalance(BigDecimal.ZERO);
        account.setPin(request.getPin());

        account.setAccountNumber(generator.generate());

        Account saved = accountRepository.save(account);

        return AccountMapper.toResponse(saved);
    }

    public BigDecimal getBalance(String accountNumber) {
        return findAccount(accountNumber).getBalance();
    }

    // 🔹 shared helper
    public Account findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }
}