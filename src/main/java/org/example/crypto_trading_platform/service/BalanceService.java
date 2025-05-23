package org.example.crypto_trading_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.BalanceDto;
import org.example.crypto_trading_platform.entity.Balance;
import org.example.crypto_trading_platform.entity.User;
import org.example.crypto_trading_platform.exception.BadBalanceRequestException;
import org.example.crypto_trading_platform.repository.BalanceRepository;
import org.example.crypto_trading_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.example.crypto_trading_platform.converter.BalanceConverter.entityToDto;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;

    public BalanceDto getBalance(String username) {
        Balance balance = balanceRepository.findByUserUsername(username)
                .orElseThrow(() -> new BadBalanceRequestException("Balance not found for the specified username: " + username));
        return entityToDto(balance);
    }

    public BalanceDto addBalance(String username, Double amount) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new BadBalanceRequestException("User not found with the specified username: " + username));
        if(amount <= 0){
            throw new BadBalanceRequestException("Amount must be greater than zero.");
        }
        Balance balanceToSave = user.getBalance();
        balanceToSave.setAmount(balanceToSave.getAmount() + amount);
        Balance savedBalance = balanceRepository.save(balanceToSave);
        return entityToDto(savedBalance);
    }

    public BalanceDto withdrawBalance(String username, Double amount) {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new BadBalanceRequestException("User not found with the specified username: " + username));
        if(amount <= 0){
            throw new BadBalanceRequestException("Amount must be greater than zero.");
        }
        Balance balanceToSave = user.getBalance();
        if (balanceToSave.getAmount() < amount){
            throw new BadBalanceRequestException("Insufficient funds in the balance for the requested amount.");
        }
        balanceToSave.setAmount(balanceToSave.getAmount() - amount);
        Balance savedBalance = balanceRepository.save(balanceToSave);
        return entityToDto(savedBalance);
    }

    public Optional<Balance> findByUsername(String username) {
        return balanceRepository.findByUserUsername(username);
    }
}
