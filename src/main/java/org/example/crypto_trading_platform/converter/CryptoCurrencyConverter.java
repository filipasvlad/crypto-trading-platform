package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.CryptoCurrencyDto;
import org.example.crypto_trading_platform.entity.CryptoCurrency;

import java.util.List;

public class CryptoCurrencyConverter {

    public static CryptoCurrencyDto entityToDto(CryptoCurrency cryptoCurrency){
        return new CryptoCurrencyDto(
                cryptoCurrency.getId(),
                cryptoCurrency.getSymbol(),
                cryptoCurrency.getPrice()
        );
    }

    public static List<CryptoCurrencyDto> entityListToDtoList(List<CryptoCurrency> cryptoCurrencies) {
        return cryptoCurrencies.stream()
                .map(CryptoCurrencyConverter::entityToDto)
                .toList();
    }
}
