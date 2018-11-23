package com.shopping.dev.order.service;

import com.shopping.dev.utils.ResultWrapper;

public interface OrderService {

    ResultWrapper findAll(Long orderId);

    ResultWrapper findByUserId(Long userId);
}
