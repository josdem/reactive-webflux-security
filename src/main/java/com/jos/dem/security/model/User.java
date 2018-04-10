package com.jos.dem.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class User {

  @Id
  private String uuid;
  private String username;
  private String email;

}