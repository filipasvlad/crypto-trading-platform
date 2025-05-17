package org.example.crypto_trading_platform.dto;

import java.time.LocalDateTime;

public record TransactionDto(
        Long id,
        String username,
        String cryptoCurrencyId,
        Double quantity,
        Double priceAtPurchase,
        Double totalAmountSpent,
        LocalDateTime timestamp
) { }