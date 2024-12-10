package org.example.crypto_trading_platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

public record UserLoginDto(
        @Null
        Long id,

        @NotBlank
        String username,

        @NotBlank
        String password
) { }