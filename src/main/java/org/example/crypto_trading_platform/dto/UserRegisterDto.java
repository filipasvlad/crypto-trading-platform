package org.example.crypto_trading_platform.dto;

import jakarta.validation.constraints.*;

public record UserRegisterDto(
        @NotBlank
        String username,
        @NotBlank
        String password
) { }
