package org.example.crypto_trading_platform.controller;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.UserDto;
import org.example.crypto_trading_platform.dto.UserRegisterDto;
import org.example.crypto_trading_platform.security.JwtService;
import org.example.crypto_trading_platform.security.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("/register")
    public UserDto register(@RequestBody UserRegisterDto userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }

    @GetMapping("/auth/check")
    public ResponseEntity<Void> checkAuth(@RequestBody String token) {
        var username = jwtService.extractUsername(token);
        var userDetails = userDetailsService.loadUserByUsername(username);

        if (jwtService.isValid(token, userDetails)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
