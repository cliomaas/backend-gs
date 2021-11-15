package com.example.cuidasampa.CuidaSampa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CuidaSampaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuidaSampaApplication.class, args);
	}

}
