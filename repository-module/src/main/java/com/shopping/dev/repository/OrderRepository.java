package com.shopping.dev.repository;

import com.shopping.dev.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 创建 JYQ  on  2018/11/21,10:48
 */
public interface OrderRepository extends JpaRepository<Order,String> {
//    @Query(value = "insert into tb_order(order_id,payment,payment_type,create_time,user_id) values (?,?,?,now(),?)", nativeQuery = true)
//    int insertOrder(Order order);
    List<Order> findAllByUserId(Long userId);

}
