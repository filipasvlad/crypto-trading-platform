package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Optional<Balance> findByUserUsername(String username);
}
