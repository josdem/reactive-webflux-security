package com.jos.dem.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import com.jos.dem.security.model.User;
import com.jos.dem.security.repository.UserRepository;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  CommandLineRunner start(UserRepository userRepository, PasswordEncoder passwordEncoder){
    return args -> {
      User user = new User("josdem", passwordEncoder.encode("12345678"));
      userRepository.save(user).subscribe();
    };
  }

}
