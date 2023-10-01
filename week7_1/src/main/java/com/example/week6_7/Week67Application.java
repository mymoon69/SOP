package com.example.week6_7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Week67Application {

	public static void main(String[] args) {
		SpringApplication.run(Week67Application.class, args);
		System.out.println("MAnee");
	}

}
