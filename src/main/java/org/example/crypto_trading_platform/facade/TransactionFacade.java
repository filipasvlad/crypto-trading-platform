package org.example.crypto_trading_platform.facade;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.TransactionDto;
import org.example.crypto_trading_platform.entity.*;
import org.example.crypto_trading_platform.exception.BadTransactionRequestException;
import org.example.crypto_trading_platform.repository.TransactionRepository;
import org.example.crypto_trading_platform.repository.UserRepository;
import org.example.crypto_trading_platform.service.BalanceService;
import org.example.crypto_trading_platform.service.CryptoCurrencyService;
import org.example.crypto_trading_platform.service.PortfolioService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.crypto_trading_platform.converter.TransacionConverter.entityToDto;
import static org.example.crypto_trading_platform.converter.TransacionConverter.entityListToDtoList;

@Service
@RequiredArgsConstructor
public class TransactionFacade {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final BalanceService balanceService;
    private final CryptoCurrencyService cryptoCurrencyService;
    private final PortfolioService portfolioService;

    @Transactional
    public TransactionDto buyCrypto(Long userId, String cryptoCurrencyId, Double quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadTransactionRequestException("User not found for the specified ID: " + userId));

        CryptoCurrency cryptoCurrency = cryptoCurrencyService.findById(cryptoCurrencyId)
                .orElseThrow(() -> new BadTransactionRequestException("CryptoCurrency not found for the given ID: " + cryptoCurrencyId));

        Double priceAtPurchase = cryptoCurrencyService.getCurrentPrice(cryptoCurrencyId);
        Double totalAmountSpent = priceAtPurchase * quantity;

        Balance userBalance = balanceService.findByUserId(userId)
                .orElseThrow(() -> new BadTransactionRequestException("Balance not found for the specified user ID: " + userId));

        if (userBalance.getAmount() < totalAmountSpent) {
            throw new BadTransactionRequestException("Insufficient funds in the balance for the requested transaction.");
        }

        Transaction transaction = Transaction.builder()
                .user(user)
                .cryptoCurrency(cryptoCurrency)
                .quantity(quantity)
                .priceAtPurchase(priceAtPurchase)
                .totalAmountSpent(totalAmountSpent)
                .build();

        transactionRepository.save(transaction);
        balanceService.withdrawBalance(userId, totalAmountSpent);
        portfolioService.addItemToPortfolio(userId, cryptoCurrencyId, quantity);
        return entityToDto(transaction);
    }

    @Transactional
    public TransactionDto sellCrypto(Long userId, String cryptoCurrencyId, Double quantity) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadTransactionRequestException("User not found for the specified ID: " + userId));

        CryptoCurrency cryptoCurrency = cryptoCurrencyService.findById(cryptoCurrencyId)
                .orElseThrow(() -> new BadTransactionRequestException("CryptoCurrency not found for the given ID: " + cryptoCurrencyId));

        Double priceAtSale = cryptoCurrencyService.getCurrentPrice(cryptoCurrencyId);
        Double totalAmountReceived = priceAtSale * quantity;

        PortfolioItem portfolioItem = portfolioService.getPortfolioItem(userId, cryptoCurrencyId)
                .orElseThrow(() -> new BadTransactionRequestException("User does not have the specified cryptocurrency in their portfolio"));

        if (portfolioItem.getQuantity() < quantity) {
            throw new BadTransactionRequestException("Insufficient quantity of the cryptocurrency in the portfolio for the requested transaction.");
        }

        Transaction transaction = Transaction.builder()
                .user(user)
                .cryptoCurrency(cryptoCurrency)
                .quantity(-quantity)
                .priceAtPurchase(priceAtSale)
                .totalAmountSpent(totalAmountReceived)
                .build();

        transactionRepository.save(transaction);

        balanceService.addBalance(userId, totalAmountReceived);

        portfolioService.removeItemFromPortfolio(userId, cryptoCurrencyId, quantity);

        return entityToDto(transaction);
    }


    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return entityListToDtoList(transactions);
    }
}