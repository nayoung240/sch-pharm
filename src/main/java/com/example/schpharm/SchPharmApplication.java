package com.example.schpharm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SchPharmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchPharmApplication.class, args);
    }

}
