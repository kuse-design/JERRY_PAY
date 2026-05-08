package com.example.jerry_pay.controllers;

import com.example.jerry_pay.dtos.request.CreateAccountRequest;
import com.example.jerry_pay.dtos.response.AccountResponse;
import com.example.jerry_pay.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@RequestBody CreateAccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalance(@RequestParam String accountNumber) {
        BigDecimal balance = accountService.getBalance(accountNumber);
        return ResponseEntity.ok(balance);
    }
}
