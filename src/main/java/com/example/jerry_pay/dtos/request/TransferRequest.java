package com.example.jerry_pay.dtos.request;

import java.math.BigDecimal;

public class TransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private String pin;
}
