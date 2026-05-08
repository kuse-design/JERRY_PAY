package com.example.jerry_pay.dtos.request;

import lombok.Data;

@Data

public class CreateAccountRequest {
    private String accountName;
    private String email;
    private String phoneNumber;
    private int age;
    private String pin;
}