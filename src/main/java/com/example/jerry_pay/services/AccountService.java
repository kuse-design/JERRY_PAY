package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.User;
import com.example.jerry_pay.data.repositories.AccountRepository;
import com.example.jerry_pay.data.repositories.UserRepository;
import com.example.jerry_pay.dtos.request.CreateAccountRequest;
import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.exception.userNotFoundException;
import com.example.jerry_pay.utils.AccountNumberGenerator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AccountService {
    private final AccountRepository acccountRepository;
    private final UserRepository userRepository;
    private final AccountNumberGenerator generator;

    public  AccountService(AccountRepository accountRepository, UserRepository userRepository,
                           AccountNumberGenerator generator){
        this.acccountRepository = accountRepository;
        this.userRepository = userRepository;
        this.generator = generator;
    }

    public AccountResponse CreateAccountRequest(CreateAccountRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new userNotFoundException("User not found");

                Account account = new Account();
                account.setBalance(BigDecimal.ZERO);
                account.setAccountNumber(generator.generate());
                account.setUser(user);

                Account saved = AccountRepository.save(account);
;
    }
}