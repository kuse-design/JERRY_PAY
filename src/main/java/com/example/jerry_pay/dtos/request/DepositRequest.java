package com.example.jerry_pay.dtos.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Data
@Document
public class DepositRequest {
    private String accountNumber;
    private BigDecimal amount;
}
