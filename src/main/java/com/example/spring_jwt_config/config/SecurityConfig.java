package com.example.spring_jwt_config.config;


import com.example.spring_jwt_config.components.security.AccessDeniedHandler;
import com.example.spring_jwt_config.components.security.CustomJwtAuthenticationConverter;
import com.example.spring_jwt_config.components.security.UnauthorizedHandler;
import com.example.spring_jwt_config.properties.RsaKeyProperties;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;


import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final RsaKeyProperties rsaKeys;
    private final UnauthorizedHandler unauthorizedHandler;
    private final AccessDeniedHandler accessDeniedHandler;
    private final CustomJwtAuthenticationConverter customJwtAuthenticationConverter;

    @Bean
    public AuthenticationManager userAuthProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 1 - Disable Cross-Site Request Forgery (CSRF)
     * 2 - The user should be authenticated for any request in the application.
     * 3 - Spring Security will never create an HttpSession and it will never use it to obtain the Security Context.
     * 4 - Spring Security’s HTTP Basic Authentication support is enabled by default. However, as soon as any servlet-based configuration is provided, HTTP Basic must be explicitly provided.
     * WARNING
     * Never disable CSRF protection while leaving session management enabled! Doing so will open you up to a Cross-Site Request Forgery attack.
     */

    private static final List<String> PERMIT_ALL = List.of(
            "/api/v1/auth/login",
            "/api/v1/auth/signup"
    );

    private static final String[] WHITE_LIST_URL = {
            "/v3/api-docs/**","/api/v1/auth/**", "/api/v1/user/**",
            "/swagger-ui/**", "/swagger-ui.html", "/api/v1/password",
            "/api/v1/image/files/**", "/api/v1/product", "/api/v1/category"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // (1)\
                .cors(httpSecurityCorsConfigurer ->
                        httpSecurityCorsConfigurer
                                .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                )
                .authorizeHttpRequests( auth -> auth
                        .requestMatchers(WHITE_LIST_URL).permitAll()
                        .anyRequest().authenticated() // (2)
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedHandler(accessDeniedHandler)
                                .authenticationEntryPoint(unauthorizedHandler)
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .authenticationEntryPoint(unauthorizedHandler)
//                        .accessDeniedHandler(accessDeniedHandler)
//                        .jwt(jwtConfigurer -> jwtConfigurer
//                                .jwtAuthenticationConverter(customJwtAuthenticationConverter)
//                        )
//                )

                .oauth2ResourceServer((oauth2) -> oauth2.jwt(withDefaults()))
//                .httpBasic(Customizer.withDefaults()) // (4)
                .build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
        JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwkSource);
    }


}
