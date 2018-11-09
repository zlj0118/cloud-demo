package com.shopping.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:毕胜朋
 * @date:2018/11/8 10:38
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LoginSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginSpringApplication.class);
    }
}
