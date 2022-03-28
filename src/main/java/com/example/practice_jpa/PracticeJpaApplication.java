package com.example.practice_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PracticeJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeJpaApplication.class, args);
    }

}
