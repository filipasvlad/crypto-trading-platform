package org.example.crypto_trading_platform.converter;

import org.example.crypto_trading_platform.dto.UserDto;
import org.example.crypto_trading_platform.dto.UserRegisterDto;
import org.example.crypto_trading_platform.entity.User;

public class UserConverter {

    public static User registerDtoToEntiry(UserRegisterDto userRegisterDto){
        return User.builder()
                .username(userRegisterDto.username())
                .password(userRegisterDto.password())
                .build();

    }

    public static UserDto entityToDto(User user){
        return new UserDto(
                user.getUsername(),
                user.getPassword()
        );
    }
}
