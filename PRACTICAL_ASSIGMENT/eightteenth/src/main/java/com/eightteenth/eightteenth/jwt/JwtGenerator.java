package com.eightteenth.eightteenth.jwt;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtGenerator implements CommandLineRunner {

    private static final String SECRET =
            "01234567890123456789012345678901";

    @Override
    public void run(String... args) {

        String token = Jwts.builder()

                .subject("admin")

                .claim("scope", "read write")

                .issuedAt(new Date())

                .expiration(
                        new Date(System.currentTimeMillis()
                                + 3600000)
                )

                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()
                        )
                )

                .compact();

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              JWT TOKEN");
        System.out.println("==========================================");
        System.out.println(token);
        System.out.println("==========================================");
        System.out.println();
    }
}