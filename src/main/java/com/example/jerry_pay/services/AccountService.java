package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.AccountStatus;
import com.example.jerry_pay.data.models.User;
import com.example.jerry_pay.data.repositories.AccountRepository;
import com.example.jerry_pay.data.repositories.UserRepository;
import com.example.jerry_pay.dtos.request.CreateAccountRequest;
import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.exception.*;
import com.example.jerry_pay.utils.AccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountNumberGenerator generator;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository,
                          AccountNumberGenerator generator) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.generator = generator;
    }

    public AccountResponse CreateAccountRequest(CreateAccountRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new userNotFoundException("User not found"));

        Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        account.setAccountNumber(generator.generate());
        account.setUser(user);

        Account saved = accountRepository.save(account);
        return AccountMapper.toResponse(saved);

    }

    public  Account findAccount(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }

    public BigDecimal getBalance(String accountNumber, String pin) {

        Account account = findAccount(accountNumber);
        if (!account.getUser().getPin().equals(pin)) {
            throw new InvalidPinException("Invalid PIN");
        }
        return account.getBalance();
    }

    public void validateAccount(Account account) {
        if (account.getStatus() == AccountStatus.SUSPENDED) {
            throw new SuspendedAccountException("Account is suspended");
        }
        if (account.getStatus() == AccountStatus.CLOSED) {
            throw new ClosedAccountException("Account is closed");
        }
    }
}



