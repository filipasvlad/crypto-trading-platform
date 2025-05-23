package org.example.crypto_trading_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.PortfolioDto;
import org.example.crypto_trading_platform.dto.PortfolioItemDto;
import org.example.crypto_trading_platform.service.PortfolioService;
import org.example.crypto_trading_platform.util.SecurityUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping
    public List<PortfolioItemDto> getPortfolioItemsByPortfolio() {
        return portfolioService.getPortfolioItemsByUserId(SecurityUtil.getCurrentUsername());
    }

    @PostMapping("/add")
    public PortfolioDto addItemToPortfolio(@RequestParam String cryptoCurrencyId, @RequestParam Double quantity) {
        return portfolioService.addItemToPortfolio(SecurityUtil.getCurrentUsername(), cryptoCurrencyId, quantity);
    }

    @PostMapping("/remove")
    public PortfolioDto removeItemFromPortfolio(@RequestParam String cryptoCurrencyId, @RequestParam Double quantity) {
        return portfolioService.removeItemFromPortfolio(SecurityUtil.getCurrentUsername(), cryptoCurrencyId, quantity);
    }

}