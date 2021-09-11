package com.jos.dem.security;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SecurityControllerTest {

  private final WebTestClient webTestClient;

  @Test
  @DisplayName("User is unauthorized")
  void shouldValidateUnauthorized() {
    webTestClient.get().uri("/").exchange().expectStatus().isUnauthorized();
  }
}
