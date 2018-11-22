package com.shopping.dev.order.controller;



import com.shopping.dev.service.LoginService;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author:毕胜朋
 * @date:2018/11/7 20:45
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Resource
    private LoginService service;

    @RequestMapping("/login")
    public ResultWrapper login(String username, String password) {
        System.out.println(username+"username");
        ResultWrapper user = service.findByUsername(username, password);
        System.out.println(user+"user");
        return service.findByUsername(username, password);
    }
}
