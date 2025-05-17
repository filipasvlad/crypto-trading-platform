package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByUserUsername(String username);
}
