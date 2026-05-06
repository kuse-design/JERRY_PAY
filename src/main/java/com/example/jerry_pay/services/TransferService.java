package com.example.jerry_pay.services;

import com.example.jerry_pay.data.models.Account;
import com.example.jerry_pay.data.models.Transaction;
import com.example.jerry_pay.data.models.TransactionType;
import com.example.jerry_pay.data.models.NotificationType;
import com.example.jerry_pay.data.repositories.TransactionRepository;
import com.example.jerry_pay.dtos.response.TransactionResponse;
import com.example.jerry_pay.utils.AppMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransferService {

    private final AccountService accountService;
    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;

    public TransferService(AccountService accountService,
                           TransactionRepository transactionRepository,
                           NotificationService notificationService) {

        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
        this.notificationService = notificationService;
    }

    public TransactionResponse transfer(String senderAcc, String receiverAcc,
                                        String pin, BigDecimal amount) {

        Account sender = accountService.findAccount(senderAcc);
        Account receiver = accountService.findAccount(receiverAcc);

        if (!sender.getUser().getPin().equals(pin)) {
            throw new RuntimeException("Invalid PIN");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        sender.setBalance(sender.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));

        Transaction transaction = new Transaction();

        transaction.setAmount(amount);
        transaction.setType(TransactionType.TRANSFER);

        transaction.setSenderAccount(sender);
        transaction.setReceiverAccount(receiver);

        transaction.setTimestamp(LocalDateTime.now());

        Transaction saved = transactionRepository.save(transaction);

        notificationService.notify(sender, amount, NotificationType.DEBIT);

        notificationService.notify(receiver, amount, NotificationType.CREDIT);

        return AppMapper.toTransactionResponse(saved);
    }
}