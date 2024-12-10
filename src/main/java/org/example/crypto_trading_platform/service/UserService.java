package org.example.crypto_trading_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.UserDto;
import org.example.crypto_trading_platform.dto.UserLoginDto;
import org.example.crypto_trading_platform.dto.UserRegisterDto;
import org.example.crypto_trading_platform.entity.Balance;
import org.example.crypto_trading_platform.entity.Portfolio;
import org.example.crypto_trading_platform.entity.User;
import org.example.crypto_trading_platform.exception.AuthenticationFailedException;
import org.example.crypto_trading_platform.repository.BalanceRepository;
import org.example.crypto_trading_platform.repository.PortfolioRepository;
import org.example.crypto_trading_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserDto register(UserRegisterDto userRegisterDTO) {
        User user = registerDtoToEntiry(userRegisterDTO);

        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        Balance balance = new Balance();
        balance.setUser(user);

        Portfolio portfolio = new Portfolio();
        portfolio.setUser(user);

        balanceRepository.save(balance);
        portfolioRepository.save(portfolio);

        return entityToDto(user);
    }

    public String verify(UserLoginDto userLoginDto) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.username(), userLoginDto.password()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userLoginDto.username());
        }
        throw new AuthenticationFailedException("Authentication failed for username: " + userLoginDto.username());
    }
}
