package com.rapido.auth_service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final KeyPair KEY_PAIR;

    static {
        try {
            KeyPairGenerator keyPairGenerator =
                    KeyPairGenerator.getInstance("RSA");

            keyPairGenerator.initialize(2048);

            KEY_PAIR = keyPairGenerator.generateKeyPair();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final PrivateKey privateKey =
            KEY_PAIR.getPrivate();

    private final PublicKey publicKey =
            KEY_PAIR.getPublic();

    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 3600000)
                )
                .signWith(
                        privateKey,
                        SignatureAlgorithm.RS256
                )
                .compact();
    }

    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {

        try {
            extractClaims(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {

        return extractClaims(token)
                .getSubject();
    }
}