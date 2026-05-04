package com.example.jerry_pay.data.repositories;

import com.example.jerry_pay.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository <User, String> {
}
