package com.jos.dem.security.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoController {

  @GetMapping("/")
  public String index() {
    return "home";
  }

}
