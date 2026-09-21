package com.eightteenth.eightteenth.config;

import org.springframework.security.config.Customizer;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import io.jsonwebtoken.security.Keys;

@Configuration
public class ResourceServerConfig {

    private static final String SECRET = "01234567890123456789012345678901";

    @Bean
    public JwtDecoder jwtDecoder() {

        SecretKey key = Keys.hmacShaKeyFor(
                SECRET.getBytes());

        return NimbusJwtDecoder
                .withSecretKey(key)
                .build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/secure/**")
                        .authenticated()

                        .anyRequest()
                        .permitAll())

                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}