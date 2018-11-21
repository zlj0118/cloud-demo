package com.shopping.dev.repository;


import com.shopping.dev.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<Item,Long> {
}
