package com.jos.dem.security;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class SecurityIntegrationTest {

  private final WebTestClient webTestClient;
  private MultiValueMap<String, String> data = new LinkedMultiValueMap<>();

  @Test
  @DisplayName("User is unauthorized")
  void shouldValidateUnauthorized() {
    webTestClient.get().uri("/").exchange().expectStatus().isUnauthorized();
  }

  @Test
  @DisplayName("User is forbidden")
  void shouldValidateForbidden() {
    data.add("username", "josdem");
    data.add("password", "password");
    webTestClient
        .post()
        .uri("/login")
        .body(BodyInserters.fromFormData(data))
        .exchange()
        .expectStatus()
        .isForbidden();
  }
}
