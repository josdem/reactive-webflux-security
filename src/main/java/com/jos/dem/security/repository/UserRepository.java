package com.jos.dem.security.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
  User findByUsername(String username);
}