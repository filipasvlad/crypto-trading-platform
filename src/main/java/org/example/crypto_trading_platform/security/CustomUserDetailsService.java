package org.example.crypto_trading_platform.security;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws BadCredentialsException {
        var user = userRepository.findById(username).orElseThrow(() -> new BadCredentialsException("User not found!"));
        if (user == null) {
            throw new BadCredentialsException("User not found!");
        }
        // TODO: vezi daca mai e necesar
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthority())
                .build();
    }
}