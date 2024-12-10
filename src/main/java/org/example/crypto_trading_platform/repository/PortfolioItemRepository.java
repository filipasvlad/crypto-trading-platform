package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    List<PortfolioItem> findByPortfolio_UserId(Long userId);
    Optional<PortfolioItem> findByPortfolio_UserIdAndCryptoCurrencyId(Long userId, String cryptoCurrencyId);
}
