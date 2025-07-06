package org.example.crypto_trading_platform.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.crypto_trading_platform.dto.CryptoCurrencyDto;
import org.example.crypto_trading_platform.entity.CryptoCurrency;
import org.example.crypto_trading_platform.exception.BadCryptoCurrencyRequestException;
import org.example.crypto_trading_platform.repository.CryptoCurrencyRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

import static org.example.crypto_trading_platform.converter.CryptoCurrencyConverter.entityListToDtoList;
import static org.example.crypto_trading_platform.converter.CryptoCurrencyConverter.entityToDto;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyService {

    private final CryptoCurrencyRepository cryptoCurrencyRepository;

    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price";

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public CryptoCurrencyDto getCryptoCurrency(String symbol) {
        var coin = cryptoCurrencyRepository.findBySymbol(symbol).orElseThrow(() ->
                new BadCryptoCurrencyRequestException("CryptoCurrency does not exist for the given symbol: " + symbol));
        return entityToDto(coin);
    }

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
        cryptoCurrencyList.sort(Comparator.comparing(CryptoCurrency::getOrderIndex, Comparator.nullsLast(Integer::compareTo)));
        System.out.println(cryptoCurrencyList);
        return entityListToDtoList(cryptoCurrencyList);
    }

    public Optional<CryptoCurrency> findById(String cryptoCurrencyId) {
        return cryptoCurrencyRepository.findById(cryptoCurrencyId);
    }

    @PostConstruct
    @Scheduled(fixedRate = 60000)
    public void updateAllPrices() {
        try {
            List<CryptoCurrency> cryptoCurrencyList = cryptoCurrencyRepository.findAll();
            // TODO: Reformat with stream
            var url = new StringBuilder("https://api.coingecko.com/api/v3/simple/price?ids=");
            for (var cryptoCurrency : cryptoCurrencyList) {
                url.append(cryptoCurrency.getId()).append(",");
            }
            url.deleteCharAt(url.length() - 1);
            url.append("&vs_currencies=usd");
            String json = restTemplate.getForObject(url.toString(), String.class);
            Map<String, Map<String, Double>> data = objectMapper.readValue(json, new TypeReference<>() {
            });
            for (var entry : data.entrySet()) {
                String id = entry.getKey();
                Double price = entry.getValue().get("usd");

                var coin = cryptoCurrencyRepository.findById(id).orElseThrow(() -> new BadCryptoCurrencyRequestException("CryptoCurrency does not exist for the given ID: " + id));
                if (price != null) {
                    coin.setBuyPrice(price);
                    coin.setSellPrice(price * 9 / 10);
                }
                else {
                    coin.setBuyPrice(-1.0);
                    coin.setSellPrice(-1.0);
                }
                cryptoCurrencyRepository.save(coin);
            }
            System.out.println("Updated prices for " + data.size() + " coins.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
