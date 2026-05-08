package com.example.jerry_pay.utils;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Notification;
import com.example.jerry_pay.data.models.Transaction;
import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.dtos.response.NotificationResponse;
import com.example.jerry_pay.dtos.response.TransactionResponse;

public class Mapper {

    public static AccountResponse toResponse(Account account) {
        AccountResponse response = new AccountResponse();
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountName(account.getUser().getAccountName());
        response.setBalance(account.getBalance());
        return response;
    }

    public static TransactionResponse toTransactionResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setAmount(transaction.getAmount());
        response.setType(transaction.getType());

        if (transaction.getSenderAccount() != null) {
            response.setSenderAccount(transaction.getSenderAccount().getAccountNumber());
        }
        if (transaction.getReceiverAccount() != null) {
            response.setReceiverAccount(transaction.getReceiverAccount().getAccountNumber());
        }
        return response;
    }

    public static NotificationResponse toNotificationResponse(Notification notification) {
        NotificationResponse response = new NotificationResponse();
        response.setMessage(notification.getMessage());
        response.setType(notification.getType());
        return response;
    }
}