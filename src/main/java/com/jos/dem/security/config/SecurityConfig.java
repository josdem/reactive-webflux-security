package com.jos.dem.security.EnableWebFluxSecurity;

import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.authentication.UserDetailsRepository;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http
      .authorizeExchange()
      .anyExchange().authenticated()
      .and()
      .httpBasic().and()
      .formLogin();
    return http.build();
  }

  @Bean
  public UserDetailsRepository userDetailsRepository() {
    UserDetails user = User.withDefaultPasswordEncoder()
      .username("josdem")
      .password("12345678")
      .roles("USER")
      .build();
    return new UserDetailsRepository(user);
  }

}
