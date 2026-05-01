package com.example.jerry_pay.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
public class User {

    private Long id;
    private String pin;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private LocalDateTime createdAt;



}
