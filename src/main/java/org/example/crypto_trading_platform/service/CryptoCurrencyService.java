package org.example.crypto_trading_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.CryptoCurrencyDto;
import org.example.crypto_trading_platform.entity.CryptoCurrency;
import org.example.crypto_trading_platform.exception.BadCryptoCurrencyRequestException;
import org.example.crypto_trading_platform.repository.CryptoCurrencyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.example.crypto_trading_platform.converter.CryptoCurrencyConverter.entityListToDtoList;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyService {

    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;

    public Double getCurrentPrice(String id){
        if (!cryptoCurrencyRepository.existsById(id)){
            throw new BadCryptoCurrencyRequestException("CryptoCurrency does not exist for the given ID: " + id);
        }

        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("ids", id.toLowerCase())
                .queryParam("vs_currencies", "usd")
                .toUriString();
        Map<String, Map<String, Double>> response = restTemplate.getForObject(url, Map.class);
        if (response != null && response.containsKey(id)) {
            return Double.parseDouble(String.valueOf(response.get(id).get("usd")));
        }
        return null;
    }

    public List<CryptoCurrencyDto> getAllCryptoCurrencies() {
        List<CryptoCurrency> cryptoCurrencyList = cryptoCurrencyRepository.findAll();
        return entityListToDtoList(cryptoCurrencyList);
    }

    public Optional<CryptoCurrency> findById(String cryptoCurrencyId) {
        return cryptoCurrencyRepository.findById(cryptoCurrencyId);
    }
}
