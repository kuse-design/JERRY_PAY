package com.example.jerry_pay.controllers;

import com.example.jerry_pay.dtos.request.TransferRequest;
import com.example.jerry_pay.dtos.response.TransactionResponse;
import com.example.jerry_pay.services.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> transfer(@RequestBody TransferRequest request) {
        TransactionResponse response = transferService.transfer(
                request.getSenderAccountNumber(),
                request.getReceiverAccountNumber(),
                request.getPin(),
                request.getAmount()
        );
        return ResponseEntity.ok(response);
    }
}