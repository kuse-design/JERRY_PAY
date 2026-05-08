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
import com.example.jerry_pay.utils.Mapper;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;


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

    public AccountResponse createAccount(CreateAccountRequest request) {
        User user = new User();
        user.setAccountName(request.getAccountName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAge(request.getAge());
        user.setPin(request.getPin());
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);

        Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        account.setAccountNumber(generator.generate());
        account.setStatus(AccountStatus.ACTIVE);
        account.setCreatedAt(LocalDateTime.now());
        account.setUser(savedUser);

        Account saved = accountRepository.save(account);
        return Mapper.toResponse(saved);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public  Account findAccount(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }

    public BigDecimal getBalance(String accountNumber) {

        Account account = findAccount(accountNumber);
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



