package org.example.crypto_trading_platform.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.UserDto;
import org.example.crypto_trading_platform.dto.UserRegisterDto;
import org.example.crypto_trading_platform.security.JwtService;
import org.example.crypto_trading_platform.security.UserService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Void> checkAuth(HttpServletRequest request) {
        var token = extractJwtFromCookies(request);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        try {
            var username = jwtService.extractUsername(token);
            var userDetails = userDetailsService.loadUserByUsername(username);

            if (jwtService.isValid(token, userDetails)) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    private String extractJwtFromCookies(HttpServletRequest request) {
        var cookies = request.getCookies();
        if (cookies != null) {
            for (var cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
