package com.espacoka.pratica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling; // 👈 IMPORTANTE

@SpringBootApplication
@EnableScheduling // 👈 ISSO ATIVA O @Scheduled
public class PraticaApplication {
    public static void main(String[] args) {
        SpringApplication.run(PraticaApplication.class, args);
    }
}