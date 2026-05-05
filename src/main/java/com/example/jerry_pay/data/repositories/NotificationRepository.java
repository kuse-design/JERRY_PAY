package com.example.jerry_pay.data.repositories;

import com.example.jerry_pay.data.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository <Notification, String>{

}
