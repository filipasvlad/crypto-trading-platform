package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, String> {
}
