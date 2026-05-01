package com.example.jerry_pay.dtos.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private String type;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
