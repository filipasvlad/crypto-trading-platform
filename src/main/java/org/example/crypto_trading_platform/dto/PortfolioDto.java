package org.example.crypto_trading_platform.dto;

import java.util.List;

public record PortfolioDto(
        Long id,
        List<PortfolioItemDto> portfolioItemsDto
) { }