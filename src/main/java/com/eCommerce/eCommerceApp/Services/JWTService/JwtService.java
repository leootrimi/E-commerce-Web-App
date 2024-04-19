package com.eCommerce.eCommerceApp.Services.JWTService;

import com.eCommerce.eCommerceApp.Models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY= "bcad837f0355f0b449df98be3291a8682e6f3d51bbfef4e655e2739b0a92ad56";

    public String generateToken(User user){
        String Token = Jwts.builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()*24*60*60*1000))
                .signWith(getSignKey())
                .compact();
        return Token;
    }

    private boolean isTokenExpired(String Token){
        return extractExpiration(Token).before(new Date());
    }

    private Date extractExpiration(String Token){
        return extraClaims(Token, Claims::getExpiration);
    }

    public boolean isValid(String Token, User user){
        String username = extractUsername(Token);
        return username.equals(user.getUsername()) && !isTokenExpired(Token);
    }


    public String extractUsername(String Token){
        return  extraClaims(Token, Claims::getSubject);
    }

    public <T> T extraClaims(String Token, Function<Claims, T> resolver){
        Claims claim = getAllClaims(Token);
        return resolver.apply(claim);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
