package com.jos.dem.security;

import java.util.UUID;

import com.jos.dem.security.repository.UserRepository;
import com.jos.dem.security.model.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
  
  @Bean
  CommandLineRunner start(UserRepository userRepository, PasswordEncoder passwordEncoder){
    return args -> {
      userRepository.deleteAll().subscribe();
      
      User user = new User();
      user.setUuid(UUID.randomUUID().toString());
      user.setUsername("josdem");
      user.setPassword(passwordEncoder.encode("12345678"));
      userRepository.save(user).subscribe();      

      userRepository.findAll().log().subscribe(System.out::println);
    };
  }
  
}
