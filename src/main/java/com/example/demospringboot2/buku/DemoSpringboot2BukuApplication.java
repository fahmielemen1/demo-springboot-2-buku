package com.example.demospringboot2.buku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DemoSpringboot2BukuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringboot2BukuApplication.class, args);
	}

}
