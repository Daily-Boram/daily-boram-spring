package com.example.dailyboramspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DailyBoramSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyBoramSpringApplication.class, args);
    }

}
