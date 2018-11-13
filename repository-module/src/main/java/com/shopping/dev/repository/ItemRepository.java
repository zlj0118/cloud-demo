package com.shopping.dev.repository;

import com.shopping.dev.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建 JYQ  on  2018/11/8,15:53
 */
public interface ItemRepository extends JpaRepository<Item,Long> {

}
