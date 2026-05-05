package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Notification;
import com.example.jerry_pay.data.models.User;
import com.example.jerry_pay.data.models.notificationType;
import com.example.jerry_pay.data.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Service
    public class NotificationService {

        private final NotificationRepository notificationRepository;

        public NotificationService(NotificationRepository notificationRepository) {
            this.notificationRepository = notificationRepository;
        }

        public void sendCreditAlert(Account account, BigDecimal amount) {

            Notification notification = new Notification();
            notification.setUser(account.getUser());
            notification.setType(notificationType.CREDIT);
            notification.setMessage("You received " + amount);
            notification.setTimeStamp(LocalDateTime.now());

            notificationRepository.save(notification);
        }

        public void sendDebitAlert(Account account, BigDecimal amount) {

            Notification notification = new Notification();
            notification.setUser(account.getUser());
            notification.setType(notificationType.DEBIT);
            notification.setMessage("You spent " + amount);
            notification.setTimeStamp(LocalDateTime.now());

            notificationRepository.save(notification);
        }
    }



