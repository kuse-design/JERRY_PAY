package com.example.jerry_pay.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Account {
    private String id;
    private String accountNumber;
    private BigDecimal balance;
    private AccountStatus status;
    private LocalDateTime createdAt;
    private User user;


}
