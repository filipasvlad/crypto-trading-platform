package org.example.crypto_trading_platform.dto;

public record PortfolioItemDto(
        Long id,
        String username,
        String cryptoCurrencyId,
        Double quantity
) { }