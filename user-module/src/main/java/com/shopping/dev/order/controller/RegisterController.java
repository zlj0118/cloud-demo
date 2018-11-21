package com.shopping.dev.order.controller;

import com.shopping.dev.entity.User;

import com.shopping.dev.service.RegisterService;

import com.shopping.dev.utils.ResultWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:毕胜朋
 * @date:2018/11/8 8:46
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private RegisterService service;
    @RequestMapping("/query")
    public ResultWrapper query(@RequestBody User user) {
        return service.findUserByUsername(user.getUsername());
    }
    @RequestMapping("/add")
    public User add(@RequestBody User user) {
        return service.addAll(user);
    }


}
