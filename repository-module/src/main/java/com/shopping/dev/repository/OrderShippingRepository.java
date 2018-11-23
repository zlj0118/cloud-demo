package com.shopping.dev.repository;

import com.shopping.dev.entity.Order;
import com.shopping.dev.entity.OrderShipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创建 JYQ  on  2018/11/21,15:55
 */
public interface OrderShippingRepository extends JpaRepository<OrderShipping,String> {
}
