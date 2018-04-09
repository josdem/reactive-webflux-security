package com.jos.dem.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DemoController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @GetMapping("/")
  public String index() {
    log.info("Calling index");
    return "home";
  }

}
