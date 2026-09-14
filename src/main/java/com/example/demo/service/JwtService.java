package com.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private SecretKey key;

    public JwtService() {
        key = Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkey12".getBytes());
    }
    public String generateToken(String email,String role){
        return Jwts.builder()
            .subject(email)
            .claim("role",role)
            .expiration(new Date(System.currentTimeMillis()+1000*60*60))
            .signWith(key)
            .compact();
    }
    public String extractEmail(String token){
        return Jwts.parser()
        .verifyWith(key)
        .build()
        .parseSignedClaims(token)
        .getPayload()
        .getSubject();
    }
    public String decodeToken(String token)
    {
        String[] parts=token.split("\\.");
        byte[] decoded=Base64.getUrlDecoder().decode(parts[0]);
        String header=new String(decoded,StandardCharsets.UTF_8);
        byte[] decoded1=Base64.getUrlDecoder().decode(parts[1]);
        String payload=new String(decoded1,StandardCharsets.UTF_8);
        return "Header:"+header+"Payload:"+payload;
}
public String encodeToken(String token1){
    String[]parts1=token1.split("\\.");
    String payload="{\"sub\":\"test@gmail.com\",\"role\":\"ROLE_ADMIN\"}";
    String encodedPayload=Base64.getUrlEncoder().withoutPadding().
    encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    return parts1[0]+"."+encodedPayload+"."+parts1[2];
}
}
