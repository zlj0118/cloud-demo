package com.shopping.dev.repository;

import com.shopping.dev.entity.Order;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from tb_order where order_id = ?;", nativeQuery = true)
    void deleteByOrderId(String orderId);
//    List<Order> findByCondition(Long userId);
}
