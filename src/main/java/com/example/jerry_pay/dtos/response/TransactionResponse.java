package com.example.jerry_pay.dtos.response;

import com.example.jerry_pay.data.models.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String senderAccount;
    private String receiverAccount;

}
