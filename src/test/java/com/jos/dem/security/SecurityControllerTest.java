package com.jos.dem.security;

import com.jos.dem.security.controller.SecurityController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.security.Principal;

class SecurityControllerTest {

  private SecurityController securityController = new SecurityController();

  @Mock private Model model;
  @Mock private Principal principal;

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("calling index")
  void shouldCallIndex() {
    Mockito.when(principal.getName()).thenReturn("josdem");
    securityController.index(model, principal);
  }
}
