package org.example.crypto_trading_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.BalanceDto;
import org.example.crypto_trading_platform.service.BalanceService;
import org.example.crypto_trading_platform.util.SecurityUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public BalanceDto getBalance() {
        return balanceService.getBalance(SecurityUtil.getCurrentUserId());
    }

    @PostMapping("/add")
    public BalanceDto addBalance(@RequestParam Double amount){
        return balanceService.addBalance(SecurityUtil.getCurrentUserId(), amount);
    }

    @PostMapping("/withdraw")
    public BalanceDto withdrawBalance(@RequestParam Double amount) {
        return balanceService.withdrawBalance(SecurityUtil.getCurrentUserId(), amount);
    }
}
