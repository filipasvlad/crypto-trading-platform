package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
