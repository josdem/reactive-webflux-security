package com.jos.dem.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

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
  public MapReactiveUserDetailsService userDetailsRepository() {
    UserDetails user = User.withDefaultPasswordEncoder()
      .username("josdem")
      .password("12345678")
      .roles("USER")
      .build();
    return new MapReactiveUserDetailsService(user);
  }

}
