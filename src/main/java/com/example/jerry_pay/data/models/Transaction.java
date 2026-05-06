package com.example.jerry_pay.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Transaction {
    private Long id;
    private TransactionType type;
    private BigDecimal amount;
//    private String reference;
    private LocalDateTime timestamp;

}
