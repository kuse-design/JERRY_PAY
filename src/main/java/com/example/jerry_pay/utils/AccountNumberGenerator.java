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
            int number = ThreadLocalRandom.current()
                    .nextInt(10000000, 100000000);

            accountNumber = "22" + number;

        } while (accountRepository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }
}
