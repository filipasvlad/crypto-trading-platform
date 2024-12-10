package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
