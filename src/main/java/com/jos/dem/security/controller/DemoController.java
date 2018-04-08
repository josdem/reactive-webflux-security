package com.jos.dem.security.controller.DemoController;

import org.springframework.web.bind.annotation.RestController;

public class DemoController {

  @GetMapping("/")
  public Mono<String> greet(Mono<Principal> principal) {
    return principal
      .map(Principal::getName)
      .map(name -> String.format("Hello, %s", name));
  }

}
