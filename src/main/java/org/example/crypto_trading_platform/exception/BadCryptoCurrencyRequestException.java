package org.example.crypto_trading_platform.exception;

public class BadCryptoCurrencyRequestException extends RuntimeException {
    public BadCryptoCurrencyRequestException(String message) {
        super(message);
    }
}
