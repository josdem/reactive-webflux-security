package com.jos.dem.security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

@Document
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
@Builder
public class User implements UserDetails {

  @Id
  private String uuid;
  private String username;
  private String email;

  @Builder.Default
  private boolean active = true;

  @Override
  public boolean isAccountNonExpired() {
    return active;
  }

  @Override
  public boolean isAccountNonLocked() {
    return active;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return active;
  }

  @Override
  public boolean isEnabled() {
    return active;
  }

}
