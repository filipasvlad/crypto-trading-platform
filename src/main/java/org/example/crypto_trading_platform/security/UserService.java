package org.example.crypto_trading_platform.security;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.UserDto;
import org.example.crypto_trading_platform.dto.UserRegisterDto;
import org.example.crypto_trading_platform.entity.Balance;
import org.example.crypto_trading_platform.entity.Portfolio;
import org.example.crypto_trading_platform.repository.BalanceRepository;
import org.example.crypto_trading_platform.repository.PortfolioRepository;
import org.example.crypto_trading_platform.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.example.crypto_trading_platform.converter.UserConverter.entityToDto;
import static org.example.crypto_trading_platform.converter.UserConverter.registerDtoToEntiry;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;
    private final PortfolioRepository portfolioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserDto register(UserRegisterDto userRegisterDTO) {
        var user = registerDtoToEntiry(userRegisterDTO);
        var balance = new Balance();
        var portfolio = new Portfolio();

        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority("ROLE_USER");

        userRepository.save(user);

        // TODO: verify if user needs id
        balance.setUser(user);
        portfolio.setUser(user);

        balanceRepository.save(balance);
        portfolioRepository.save(portfolio);

        return entityToDto(user);
    }
}
