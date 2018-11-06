package com.shopping.dev.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {


    @GetMapping("/home")
    public String home() {
        return "Auth/HomePage";
    }
}
