package com.shopping.dev.repository;


import com.shopping.dev.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<Item,Long> {
    List<Item> findAllById(Long itemId);
}

