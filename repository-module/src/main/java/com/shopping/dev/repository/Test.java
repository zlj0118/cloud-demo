package com.shopping.dev.repository;

import javax.annotation.Resource;

public class Test {

    @Resource
    private UserRepository userRepository;

    public void test() {
        System.out.println("test");
        userRepository.findAll();
    }
}
