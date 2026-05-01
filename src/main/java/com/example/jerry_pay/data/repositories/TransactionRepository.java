package com.example.jerry_pay.data.repositories;

import com.example.jerry_pay.data.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {
}
