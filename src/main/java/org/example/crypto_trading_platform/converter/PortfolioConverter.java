package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.PortfolioDto;
import org.example.crypto_trading_platform.entity.Portfolio;


public class PortfolioConverter {
    public static PortfolioDto entityToDto(Portfolio portfolio){
        return new PortfolioDto(
                portfolio.getId(),
                PorfolioItemConverter.entityListToDtoList(portfolio.getPortfolioItems())
        );
    }
}
