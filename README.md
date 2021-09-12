Spring WebFlux Security
----------------------------

[![Build Status](https://app.travis-ci.com/josdem/reactive-webflux-security.svg?branch=master)](https://app.travis-ci.com/josdem/reactive-webflux-security)
[![Quality Gate Status](https://sonar.josdem.io/api/project_badges/measure?project=com.jos.dem.security%3Areactive-webflux-security&metric=alert_status)](https://sonar.josdem.io/dashboard?id=com.jos.dem.security%3Areactive-webflux-security)

This project shows how to implement in-Memory and Database authentication in a [Spring Webflux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html) project


#### To run the project

```bash
gradle bootRun
```

#### To test the project

```bash
gradle test
```

#### To run tests with Jacoco and Sonarqube

```bash
gradle -Dsonar.login=${SONAR_TOKEN} jacocoTestReport sonarqube test
```

Where:

- `${SONAR_TOKEN}` is a sonar token to authenticate with the server (Ask me for it :)

#### Read this as reference

* http://josdem.io/techtalk/spring/spring_webflux_security/
* http://josdem.io/techtalk/spring/spring_webflux_security_database/

