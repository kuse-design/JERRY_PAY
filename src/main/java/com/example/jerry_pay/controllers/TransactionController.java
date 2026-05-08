package com.example.jerry_pay.controllers;

import com.example.jerry_pay.dtos.request.DepositRequest;
import com.example.jerry_pay.dtos.request.WithdrawRequest;
import com.example.jerry_pay.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody DepositRequest request) {
        transactionService.deposit(request.getAccountNumber(), request.getAmount());
        return ResponseEntity.ok("Deposit successful");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestBody WithdrawRequest request) {
        transactionService.withdraw(request.getAccountNumber(), request.getPin(), request.getAmount());
        return ResponseEntity.ok("Withdrawal successful");
    }
}