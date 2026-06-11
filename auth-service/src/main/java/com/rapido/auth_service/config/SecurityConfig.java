package com.rapido.auth_service.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain authorizationServerSecurityFilterChain(
            HttpSecurity http) throws Exception {

        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);

        return http
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .headers(headers -> headers

                        .frameOptions(frame -> frame.sameOrigin())

                        .contentSecurityPolicy(csp ->
                                csp.policyDirectives("default-src 'self'"))

                        .httpStrictTransportSecurity(hsts ->
                                hsts.includeSubDomains(true)
                                        .maxAgeInSeconds(31536000))

                        .contentTypeOptions(Customizer.withDefaults())
                )

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/auth/**")
                        .permitAll()

                        .requestMatchers("/user/**")
                        .hasAnyRole("USER", "SUPER_ADMIN")

                        .requestMatchers("/driver/**")
                        .hasAnyRole("DRIVER", "SUPER_ADMIN")

                        .requestMatchers("/admin/**")
                        .permitAll()

                        .anyRequest()
                        .permitAll()
                )

                .formLogin(form -> form.disable())

                .httpBasic(httpBasic -> httpBasic.disable());

        return http.build();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(
            PasswordEncoder passwordEncoder) {

        RegisteredClient registeredClient =
                RegisteredClient.withId(UUID.randomUUID().toString())
                        .clientId("rapido-client")
                        .clientSecret(passwordEncoder.encode("secret"))

                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.CLIENT_SECRET_BASIC)

                        .authorizationGrantType(
                                AuthorizationGrantType.AUTHORIZATION_CODE)

                        .authorizationGrantType(
                                AuthorizationGrantType.CLIENT_CREDENTIALS)

                        .authorizationGrantType(
                                AuthorizationGrantType.REFRESH_TOKEN)

                        .redirectUri(
                                "http://127.0.0.1:8080/login/oauth2/code/rapido")

                        .scope("openid")
                        .scope("profile")
                        .scope("ride.read")
                        .scope("ride.write")
                        .scope("payment.read")
                        .scope("payment.write")
                        .scope("admin.read")
                        .scope("admin.write")

                        .build();

        return new InMemoryRegisteredClientRepository(
                registeredClient);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}