package com.example.SpringSecurity.Spring_Security.webToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
@Service
public class JwtService {
    public static final String SECRET="26B7819E3CBB1FE86BCDCBEA126781C85609A90105620596912645074D15D190663B046CA7A1DAF1839B798C376EDCAE9C6D6ABBF104B7720EB0A8A61E18681";
    public static final long VALIDITY= TimeUnit.MINUTES.toMillis(30);
    //generate jwt token
    public String generateToken(UserDetails userDetails){
        Map<String , Object> claims=new HashMap<>();
        claims.put("name","Yadnyesh");
        claims.put("iss","https://www.geeksforgeeks.org/spring-mvc-multiple-controller/?ref=lbp");
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusMillis(VALIDITY)))
                .signWith(generateKey())
                .compact();

    }

    private SecretKey generateKey() {
        byte[] decodedKey = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    // Extract username from JWT
    public String extractusername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    //used in both method
    private Claims getClaims(String jwt) {
        Claims claims = Jwts.parserBuilder() // Updated method
                .setSigningKey(generateKey()) // Use setSigningKey instead of verifyWith
                .build()
                .parseClaimsJws(jwt) // parse the signed JWT
                .getBody(); // Extract the payload
        return claims;
    }

    public boolean isTokenValid(String jwt) {
        Claims claims=getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }
}
