package org.example.crypto_trading_platform.exception;

public class BadBalanceRequestException extends RuntimeException {
    public BadBalanceRequestException(String message) {
        super(message);
    }
}
