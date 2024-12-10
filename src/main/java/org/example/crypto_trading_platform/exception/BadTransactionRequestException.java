package org.example.crypto_trading_platform.exception;

public class BadTransactionRequestException extends RuntimeException {
    public BadTransactionRequestException(String message) {
        super(message);
    }
}
