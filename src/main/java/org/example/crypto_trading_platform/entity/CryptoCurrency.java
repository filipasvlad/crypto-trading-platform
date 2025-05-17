package org.example.crypto_trading_platform.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cryptocurrencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoCurrency {
    @Id
    private String id;

    @Column(unique = true)
    private String symbol;

    private Double price;

    @OneToMany(mappedBy = "cryptoCurrency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PortfolioItem> portfolioItems;

    @OneToMany(mappedBy = "cryptoCurrency", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}
