package com.jos.dem.security.config;

import com.jos.dem.security.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

  @Autowired
  private UserRepository userRepository;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http
      .authorizeExchange()
      .anyExchange()
      .authenticated()
      .and()
      .httpBasic()
      .and()
      .formLogin();
    return http.build();
  }

  @Bean
  public ReactiveUserDetailsService userDetailsService() {
    return (username) -> userRepository.findByUsername(username).cast(UserDetails.class);
  }

}
