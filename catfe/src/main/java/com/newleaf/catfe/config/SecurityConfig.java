package com.newleaf.catfe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/user/**")).authenticated()
                .anyRequest().permitAll();

        http.formLogin(formLogin -> formLogin
                .loginPage("/account/login")                // Maps to the page url

                .loginProcessingUrl("/account/login"));     // Maps to the specified url after processing


        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                // this is the URL that will log a user out
                // this is another URL that is included with spring security - we do not have a controller method for this
                .logoutUrl("/account/logout")
                // after spring logs the user out then it will goto this URL
                .logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}