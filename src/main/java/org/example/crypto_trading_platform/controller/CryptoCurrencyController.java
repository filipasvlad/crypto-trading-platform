package org.example.crypto_trading_platform.controller;


import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.CryptoCurrencyDto;
import org.example.crypto_trading_platform.service.CryptoCurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crypto")
@RequiredArgsConstructor
public class CryptoCurrencyController {

    private final CryptoCurrencyService cryptoCurrencyService;

    @GetMapping
    public List<CryptoCurrencyDto> getAllCryptoCurrencies(){
        return cryptoCurrencyService.getAllCryptoCurrencies();
    }

    @GetMapping("/price/{symbol}")
    public Double getPrice(@PathVariable String symbol) {
        return cryptoCurrencyService.getCurrentPrice(symbol);
    }
}