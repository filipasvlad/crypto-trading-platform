package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.PortfolioItemDto;
import org.example.crypto_trading_platform.entity.PortfolioItem;

import java.util.List;

public class PorfolioItemConverter {
    public static PortfolioItemDto entityToDto(PortfolioItem portfolioItem){
        return new PortfolioItemDto(
                portfolioItem.getId(),
                portfolioItem.getPortfolio().getUser().getUsername(),
                portfolioItem.getCryptoCurrency().getId(),
                portfolioItem.getQuantity()
        );
    }

    public static List<PortfolioItemDto> entityListToDtoList(List<PortfolioItem> portfolioItems) {
        return portfolioItems.stream()
                .map(PorfolioItemConverter::entityToDto)
                .toList();
    }
}

