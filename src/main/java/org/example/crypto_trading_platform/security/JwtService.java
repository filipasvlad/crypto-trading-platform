package org.example.crypto_trading_platform.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretkey;

    public JwtService(@Value("${jwt.key}") String secretKey) {
        this.secretkey = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserDetails userDetails) {
        var now = Instant.now();
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(Duration.ofMinutes(1000000 * 60 * 30))))
                .claim("role", userDetails.getAuthorities().iterator().next().getAuthority())
                .signWith(secretkey, Jwts.SIG.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role").toString();
    }

    public Date extractExpirationDate(String token) {
        return extractClaims(token).getExpiration();
    }

    private Claims extractClaims(String token) {
        var parser = Jwts.parser().verifyWith(secretkey).build();
        return parser.parseSignedClaims(token).getPayload();
    }

    public boolean isValid(String token, UserDetails userDetails) {
        var username = extractUsername(token);
        var expirationDate = extractExpirationDate(token);
        var role = extractRole(token);
        return username.equals(userDetails.getUsername()) &&
                role.equals(userDetails.getAuthorities().iterator().next().getAuthority()) &&
                expirationDate.after(Date.from(Instant.now()));
    }



}
