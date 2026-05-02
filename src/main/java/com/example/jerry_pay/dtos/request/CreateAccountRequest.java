package com.example.jerry_pay.dtos.request;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CreateAccountRequest {
    private String accountName;
}
