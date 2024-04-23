package com.example.quara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing
public class QuaraApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuaraApplication.class, args);
    }

}
