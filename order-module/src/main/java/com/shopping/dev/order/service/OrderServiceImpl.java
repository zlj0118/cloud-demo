package com.shopping.dev.order.service;

import com.shopping.dev.entity.Order;
import com.shopping.dev.repository.OrderRepository;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderRepository orderRepository;

    @Override
    public ResultWrapper findAll(Long userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return ResultWrapper.success(orders);
    }

    @Override
    public ResultWrapper findByUserId(Long userId) {
        
        return null;
    }


}
