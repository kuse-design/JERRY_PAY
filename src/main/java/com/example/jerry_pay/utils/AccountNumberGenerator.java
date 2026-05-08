package com.example.jerry_pay.utils;

import com.example.jerry_pay.data.repositories.AccountRepository;
import org.springframework.stereotype.Component;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class AccountNumberGenerator {

    private final AccountRepository accountRepository;

    public AccountNumberGenerator(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String generate() {

        String accountNumber;

        do {

            StringBuilder builder = new StringBuilder("22");

            for (int count = 0; count < 8; count++) {
                builder.append(ThreadLocalRandom.current().nextInt(10));
            }
            accountNumber = builder.toString();

        } while (accountRepository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }
}