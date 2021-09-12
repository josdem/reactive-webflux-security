package com.jos.dem.security.config;

import com.jos.dem.security.model.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final ApplicationConfig config;

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.authorizeExchange().anyExchange().authenticated().and().httpBasic().and().formLogin();
    return http.build();
  }

  @Bean
  public MapReactiveUserDetailsService userDetailsService() {
    UserDetails user =
        User.withDefaultPasswordEncoder()
            .username(config.getUsername())
            .password(config.getPassword())
            .roles(Roles.USER.name())
            .build();
    return new MapReactiveUserDetailsService(user);
  }
}
