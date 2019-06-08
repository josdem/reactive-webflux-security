package com.jos.dem.security.config;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@Document
@AllArgsConstructor
public class Person {

  @Id
  private String nickname;
  private String email;

}
