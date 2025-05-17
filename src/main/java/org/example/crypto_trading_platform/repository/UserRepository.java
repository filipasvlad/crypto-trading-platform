package org.example.crypto_trading_platform.repository;

import org.example.crypto_trading_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
}
