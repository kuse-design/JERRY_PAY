package com.example.jerry_pay.dtos.response;

import com.example.jerry_pay.data.models.NotificationType;
import lombok.Data;

@Data
public class NotificationResponse {
    private String Message;
    private NotificationType type;
}
