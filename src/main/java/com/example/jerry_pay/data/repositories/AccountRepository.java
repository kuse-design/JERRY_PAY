package com.example.jerry_pay.data.repositories;

import com.example.jerry_pay.data.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository <Account, String>{
        Account findByAccountNumber(String accountNumber);
        boolean existsByAccountNumber(String accountNumber);
    }

