package org.example.crypto_trading_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.TransactionDto;
import org.example.crypto_trading_platform.facade.TransactionFacade;
import org.example.crypto_trading_platform.util.SecurityUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionFacade transactionFacade;

    @GetMapping
    public List<TransactionDto> getAllTransactions() {
        return transactionFacade.getAllTransactions();
    }

    @PostMapping("/buy")
    public TransactionDto buyCrypto(@RequestParam String cryptoCurrencyId, @RequestParam Double quantity) {
        return transactionFacade.buyCrypto(SecurityUtil.getCurrentUserId(), cryptoCurrencyId, quantity);
    }

    @PostMapping("/sell")
    public TransactionDto sellCrypto(@RequestParam String cryptoCurrencyId, @RequestParam Double quantity) {
        return transactionFacade.sellCrypto(SecurityUtil.getCurrentUserId(), cryptoCurrencyId, quantity);
    }
}