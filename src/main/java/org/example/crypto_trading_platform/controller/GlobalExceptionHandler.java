package org.example.crypto_trading_platform.controller;

import org.example.crypto_trading_platform.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class,
            BadCredentialsException.class,
            BadBalanceRequestException.class,
            AuthenticationFailedException.class,
            BadCryptoCurrencyRequestException.class,
            BadTransactionRequestException.class,
            BadPortfolioRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExceptionWithMessage(Exception exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDuplicateUsernameException(Exception exception) {
        return "The username is already taken. Please choose a different one.";
    }
}