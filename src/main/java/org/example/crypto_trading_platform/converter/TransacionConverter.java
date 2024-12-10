package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.TransactionDto;
import org.example.crypto_trading_platform.entity.Transaction;

import java.util.List;

public class TransacionConverter {
    public static TransactionDto entityToDto(Transaction transaction){
        return new TransactionDto(
                transaction.getId(),
                transaction.getUser().getId(),
                transaction.getCryptoCurrency().getId(),
                transaction.getQuantity(),
                transaction.getPriceAtPurchase(),
                transaction.getTotalAmountSpent(),
                transaction.getTimestamp()
        );
    }

    public static List<TransactionDto> entityListToDtoList(List<Transaction> transactions) {
        return transactions.stream()
                .map(TransacionConverter::entityToDto)
                .toList();
    }
}
