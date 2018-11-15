package com.shopping.dev.repository;

import com.shopping.dev.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminContentRepository extends JpaRepository<Content, Long> {
    @Query(value = "select * from tb_content where category_id = ? limit ? , ?;", nativeQuery = true)
    List<Content> findAllByCategoryId(int categoryId, int begin, int rows);
    @Query(value = "select count(id) from tb_content;", nativeQuery = true)
    int findTotal();
}
