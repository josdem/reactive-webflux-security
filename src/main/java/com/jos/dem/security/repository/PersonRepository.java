package com.jos.dem.security.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jos.dem.webflux.model.Person;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {}
