package com.example.week7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Week7Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7Application.class, args);
		System.out.println("Manee");
	}

}
