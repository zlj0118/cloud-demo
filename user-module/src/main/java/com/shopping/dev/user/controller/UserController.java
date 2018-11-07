package com.shopping.dev.user.controller;

import com.shopping.dev.entity.User;
import com.shopping.dev.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Resource
    public UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "Auth/HomePage";
    }
//
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
