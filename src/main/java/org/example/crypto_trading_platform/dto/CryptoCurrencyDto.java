package org.example.crypto_trading_platform.dto;

public record CryptoCurrencyDto(
        String id,
        String symbol,
        Double buyPrice,
        Double sellPrice,
        Integer orderIndex

) { }
