package com.shopping.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FrontServeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontServeApplication.class,args);
    }
}
