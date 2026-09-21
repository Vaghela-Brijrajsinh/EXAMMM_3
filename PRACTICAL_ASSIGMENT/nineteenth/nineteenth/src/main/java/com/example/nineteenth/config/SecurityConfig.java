package com.example.nineteenth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            // Disable CSRF for REST API testing
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/oauth2/**")
                .permitAll()

                .requestMatchers("/login/**")
                .permitAll()

                .anyRequest()
                .authenticated()
            )

         .oauth2Login(oauth -> oauth
    .defaultSuccessUrl("/api/user/profile", true)
);

        return http.build();
    }
}