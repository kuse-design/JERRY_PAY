package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Notification;
import com.example.jerry_pay.data.models.User;
import com.example.jerry_pay.data.models.notificationType;
import com.example.jerry_pay.data.repositories.NotificationRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(User user, BigDecimal amount, notificationType type){
        String message;
        if(type == notificationType.CREDIT){
            message = ("your account has been credited with" + amount);
        }else{
            message = ("your account has been debited with" + amount);
        }

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setAmount(amount);
        notification.setType(type);
        notification.setMessage(message);
        notification.setTimeStamp(LocalDateTime.now());
        notificationRepository.save(notification);
    }


}
