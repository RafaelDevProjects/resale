package com.enterprise.resale.security;

import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/reservas").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/reservas/**").authenticated()
                        .requestMatchers("/salas/**").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(basic -> {}); // ✅ NOVO PADRÃO

        return http.build();
    }
}