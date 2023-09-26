package com.example.week82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Week82Application {

    public static void main(String[] args) {
        SpringApplication.run(Week82Application.class, args);
    }

}
