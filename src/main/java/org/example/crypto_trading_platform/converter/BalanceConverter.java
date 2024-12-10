package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.BalanceDto;
import org.example.crypto_trading_platform.entity.Balance;

public class BalanceConverter {

    public static BalanceDto entityToDto(Balance balance){
        return new BalanceDto(
                balance.getId(),
                balance.getAmount()
        );
    }
}
