package com.picpay.picpay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(requests -> requests
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/actuator/**").permitAll()  // Permite o acesso ao Swagger
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
