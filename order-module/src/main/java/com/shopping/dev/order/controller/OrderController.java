package com.shopping.dev.order.controller;

import com.shopping.dev.order.service.OrderService;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/all")
    public ResultWrapper allOrder(@RequestParam(name = "userId") Long userId){
        ResultWrapper orders = orderService.findAll(userId);
        return orders;
    }
}
