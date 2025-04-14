package com.ohgiraffers.sessionsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ohgiraffers.sessionsecurity")
@EnableJpaRepositories(basePackages = "com.ohgiraffers.sessionsecurity")
public class SessionSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SessionSecurityApplication.class, args);
    }
} 