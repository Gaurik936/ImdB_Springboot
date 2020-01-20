package com.project.example.model.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImdBApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImdBApplication.class, args);
	}
}
