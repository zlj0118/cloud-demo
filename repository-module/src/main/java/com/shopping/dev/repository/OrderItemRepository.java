package com.shopping.dev.repository;

import com.shopping.dev.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 创建 JYQ  on  2018/11/21,16:01
 */
public interface OrderItemRepository extends JpaRepository<OrderItem,String> {
}
