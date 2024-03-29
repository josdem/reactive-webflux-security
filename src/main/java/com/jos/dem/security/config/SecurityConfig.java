package com.jos.dem.security.config;

import com.jos.dem.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final UserRepository userRepository;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.authorizeExchange().anyExchange().authenticated().and().httpBasic().and().formLogin();
    return http.build();
  }

  @SuppressWarnings("deprecation")
  @Bean
  public ReactiveUserDetailsService userDetailsService() {
    return (username) -> userRepository.findByUsername(username);
  }
}
