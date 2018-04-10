package com.jos.dem.security.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DemoController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/")
  public String index(Model model, Principal principal) {
    log.info("Authenticated user is: " + principal.getName());
    model.addAttribute("username", principal.getName());
    return "home";
  }

}
