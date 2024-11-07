package com.picpay.picpay.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secretKey = "mySecretKey";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token válido por 10 horas
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Método para extrair o nome de usuário do token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Método para extrair qualquer informação do token
    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    // Método para extrair todas as claims do token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Verifica se o token expirou
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extrai a data de expiração do token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Verifica se o token é válido
    public boolean isValid(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

    @FunctionalInterface
    private interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
}
