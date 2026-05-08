package com.example.jerry_pay.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class Transaction {
    private String id;
    private TransactionType Type;
    private BigDecimal amount;
    private Account senderAccount;
    private Account receiverAccount;
    private LocalDateTime timestamp;

}
