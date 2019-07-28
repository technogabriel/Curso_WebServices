package com.eduit.spring.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.eduit.spring.ws")
@EnableAutoConfiguration
public class Application {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

}