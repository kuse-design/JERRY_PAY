package com.example.jerry_pay.exception;

public class ClosedAccountException extends RuntimeException {
    public ClosedAccountException(String message) {
        super(message);
    }
}
