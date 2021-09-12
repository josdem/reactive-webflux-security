package com.jos.dem.security;

import com.jos.dem.security.controller.SecurityController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.security.Principal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    String username = "josdem";
    when(principal.getName()).thenReturn(username);
    securityController.index(model, principal);
    verify(model).addAttribute("username", username);
  }
}
