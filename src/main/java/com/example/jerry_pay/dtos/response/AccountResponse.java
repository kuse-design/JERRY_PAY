package com.example.jerry_pay.dtos.response;

import com.example.jerry_pay.data.models.AccountStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class AccountResponse {
    private String accountNumber;
    private String accountName;
    private BigDecimal balance;
}
