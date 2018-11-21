package com.shopping.dev.repository;

import com.shopping.dev.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select * from tb_item limit ? , ?;", nativeQuery = true)
    List<Item> findAllItem(int begin, int row);
    @Query(value = "select count(id) from tb_item;", nativeQuery = true)
    int findTotal();


}
