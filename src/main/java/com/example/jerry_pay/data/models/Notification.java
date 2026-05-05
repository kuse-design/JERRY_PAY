package com.example.jerry_pay.data.models;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Notification {
    private String id;
    private String message;
    private LocalDateTime timeStamp;
    private notificationType type;
    private User user;

}
