package org.example.crypto_trading_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.PortfolioDto;
import org.example.crypto_trading_platform.dto.PortfolioItemDto;
import org.example.crypto_trading_platform.entity.CryptoCurrency;
import org.example.crypto_trading_platform.entity.Portfolio;
import org.example.crypto_trading_platform.entity.PortfolioItem;
import org.example.crypto_trading_platform.exception.BadPortfolioRequestException;
import org.example.crypto_trading_platform.repository.CryptoCurrencyRepository;
import org.example.crypto_trading_platform.repository.PortfolioItemRepository;
import org.example.crypto_trading_platform.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.crypto_trading_platform.converter.PorfolioItemConverter.entityListToDtoList;
import static org.example.crypto_trading_platform.converter.PortfolioConverter.entityToDto;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    private final PortfolioItemRepository portfolioItemRepository;

    public PortfolioDto addItemToPortfolio(String username, String cryptoCurrencyId, Double quantity) {
        Portfolio portfolio = portfolioRepository.findByUserUsername(username)
                .orElseThrow(() -> new BadPortfolioRequestException("Portfolio not found for the specified user username: " + username));

        CryptoCurrency cryptoCurrency = cryptoCurrencyRepository.findById(cryptoCurrencyId)
                .orElseThrow(() -> new BadPortfolioRequestException("CryptoCurrency not found for the given ID: " + cryptoCurrencyId));

        if (quantity <= 0) {
            throw new BadPortfolioRequestException("Quantity must be greater than zero.");
        }

        Optional<PortfolioItem> existingPortfolioItem = portfolioItemRepository.findByPortfolio_UserUsernameAndCryptoCurrencyId(username, cryptoCurrencyId);

        PortfolioItem portfolioItem;

        if (existingPortfolioItem.isPresent()) {
            portfolioItem = existingPortfolioItem.get();
            portfolioItem.setQuantity(portfolioItem.getQuantity() + quantity);
        } else {
            portfolioItem = new PortfolioItem();
            portfolioItem.setPortfolio(portfolio);
            portfolioItem.setCryptoCurrency(cryptoCurrency);
            portfolioItem.setQuantity(quantity);
        }

        portfolioItemRepository.save(portfolioItem);

        portfolio.getPortfolioItems().add(portfolioItem);
        portfolioRepository.save(portfolio);

        return entityToDto(portfolio);
    }

    public PortfolioDto removeItemFromPortfolio(String username, String cryptoCurrencyId, Double quantity) {
        Portfolio portfolio = portfolioRepository.findByUserUsername(username)
                .orElseThrow(() -> new BadPortfolioRequestException("Portfolio not found for the specified user username: " + username));

        if(!cryptoCurrencyRepository.existsById(cryptoCurrencyId)){
            throw new BadPortfolioRequestException("CryptoCurrency not found for the given ID: " + cryptoCurrencyId);
        }

        if (quantity <= 0) {
            throw new BadPortfolioRequestException("Quantity must be greater than zero.");
        }

        Optional<PortfolioItem> existingPortfolioItem = portfolioItemRepository.findByPortfolio_UserUsernameAndCryptoCurrencyId(username, cryptoCurrencyId);

        if (existingPortfolioItem.isEmpty()) {
            throw new BadPortfolioRequestException("The user does not own the specified cryptocurrency in their portfolio.");
        }

        PortfolioItem portfolioItem = existingPortfolioItem.get();

        if (portfolioItem.getQuantity() < quantity) {
            throw new BadPortfolioRequestException("Insufficient quantity of the cryptocurrency to remove from the portfolio.");
        }

        portfolioItem.setQuantity(portfolioItem.getQuantity() - quantity);

        if (portfolioItem.getQuantity() <= 0) {
            portfolioItemRepository.delete(portfolioItem);
            portfolio.getPortfolioItems().remove(portfolioItem);
        } else {
            portfolioItemRepository.save(portfolioItem);
        }

        portfolioRepository.save(portfolio);

        return entityToDto(portfolio);
    }

    public List<PortfolioItemDto> getPortfolioItemsByUserId(String username) {
        List<PortfolioItem> portfolioItems = portfolioItemRepository.findByPortfolio_UserUsername(username);
        return entityListToDtoList(portfolioItems);
    }

    public Optional<PortfolioItem> getPortfolioItem(String username, String cryptoCurrencyId) {
        return portfolioItemRepository.findByPortfolio_UserUsernameAndCryptoCurrencyId(username, cryptoCurrencyId);
    }


}