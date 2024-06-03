package com.elaparato.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public static final String ADMIN = "administrador";
    public static final String VENDEDOR = "vendedores";
    public static final String REPOSITOR = "repositor";
    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/test/anonymous", "/test/anonymous/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/test/admin", "/test/admin/**").hasRole(ADMIN)
                .requestMatchers(HttpMethod.GET, "/test/vendedor").hasAnyRole(VENDEDOR, ADMIN)
                .requestMatchers(HttpMethod.GET, "/test/repositor").hasAnyRole(REPOSITOR, ADMIN)
                .requestMatchers(HttpMethod.GET, "/ventas/getall").hasAnyRole(VENDEDOR, ADMIN)
                .requestMatchers(HttpMethod.GET, "/productos/getall").hasAnyRole(REPOSITOR, ADMIN)
                .requestMatchers(HttpMethod.GET, "/users/all").hasAnyRole(ADMIN)
                .requestMatchers(HttpMethod.GET, "/users/username/**").hasAnyRole(ADMIN)
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

}
