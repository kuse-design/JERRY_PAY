package com.example.jerry_pay.utils;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Notification;
import com.example.jerry_pay.data.models.Transaction;
import com.example.jerry_pay.data.models.User;

import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.dtos.response.NotificationResponse;
import com.example.jerry_pay.dtos.response.TransactionResponse;
import com.example.jerry_pay.dtos.response.UserResponse;

public class Mapper {

    private Mapper() {
    }

    public static AccountResponse map(Account account) {

        AccountResponse response = new AccountResponse();

        response.setAccountNumber(account.getAccountNumber());

        response.setBalance(account.getBalance());

        response.setStatus(account.getStatus());

        response.setCreatedAt(account.getCreatedAt());

        if (account.getUser() != null) {
            response.setAccountName(
                    account.getUser().getAccountName()
            );
        }

        return response;
    }

    public static UserResponse map(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());

        response.setAccountName(user.getAccountName());

        response.setEmail(user.getEmail());

        response.setPhoneNumber(user.getPhoneNumber());

        response.setAge(user.getAge());

        response.setCreatedAt(user.getCreatedAt());

        return response;
    }

    public static TransactionResponse map(Transaction transaction) {

        TransactionResponse response = new TransactionResponse();

        response.setId(transaction.getId());

        response.setAmount(transaction.getAmount());

        response.setType(transaction.getType());

        response.setDirection(transaction.getDirection());

        response.setTimestamp(transaction.getTimestamp());

        if (transaction.getSenderAccount() != null) {

            response.setSenderAccountNumber(
                    transaction.getSenderAccount().getAccountNumber());
        }

        if (transaction.getReceiverAccount() != null) {

            response.setReceiverAccountNumber(
                    transaction.getReceiverAccount().getAccountNumber()
            );
        }

        return response;
    }

    public static NotificationResponse map(Notification notification) {

        NotificationResponse response = new NotificationResponse();

        response.setId(notification.getId());

        response.setMessage(notification.getMessage());

        response.setType(notification.getType());

        response.setTimestamp(notification.getTimeStamp());

        if (notification.getUser() != null) {
            response.setAccountName(notification.getUser().getAccountName());
        }

        return response;
    }
}