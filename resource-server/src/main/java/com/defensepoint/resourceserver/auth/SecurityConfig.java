package com.defensepoint.resourceserver.auth;

import org.keycloak.adapters.authorization.integration.jakarta.ServletPolicyEnforcerFilter;
import org.keycloak.representations.adapters.config.PolicyEnforcerConfig;
import org.keycloak.util.JsonSerialization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.Filter;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/hello/all").permitAll()
                        .antMatchers("/hello/user").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .addFilterBefore((Filter) createPolicyEnforcerFilter(), BearerTokenAuthenticationFilter.class);

        return http.build();
    }

    private ServletPolicyEnforcerFilter createPolicyEnforcerFilter() {
        try {
            PolicyEnforcerConfig config = JsonSerialization.readValue(
                    getClass().getResourceAsStream("/policy-enforcer.json"),
                    PolicyEnforcerConfig.class
            );
            return new ServletPolicyEnforcerFilter(request -> config);
        } catch (IOException e) {
            throw new RuntimeException("Error reading policy-enforcer.json", e);
        }
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }
}
