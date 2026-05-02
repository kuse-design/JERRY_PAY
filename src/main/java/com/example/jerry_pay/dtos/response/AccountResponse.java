package com.example.jerry_pay.dtos.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponse {
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
}
