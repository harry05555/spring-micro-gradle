package com.harry05.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.harry05.customer",
                "com.harry05.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.harry05.clients"
)
public class CustomerApplication {
    public static void main( String[] args ) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}