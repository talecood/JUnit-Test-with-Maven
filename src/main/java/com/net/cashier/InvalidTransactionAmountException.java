package com.net.cashier;

public class InvalidTransactionAmountException extends RuntimeException{

    public InvalidTransactionAmountException(String message) {
        super(message);
    }
}
