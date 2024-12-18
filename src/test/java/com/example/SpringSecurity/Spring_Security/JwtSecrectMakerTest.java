package com.example.SpringSecurity.Spring_Security;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;

public class JwtSecrectMakerTest {

    @Test
    public void generateSecretKey(){
        SecretKey key= Jwts.SIG.HS512.key().build();
        String encodedKey= DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\nkey=[%s]\n",encodedKey);
    }
}
