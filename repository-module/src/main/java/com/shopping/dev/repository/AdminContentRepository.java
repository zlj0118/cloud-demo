package com.shopping.dev.repository;

import com.shopping.dev.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminContentRepository extends JpaRepository<Content, Long> {
    @Query(value = "select * from tb_content " +
            "where category_id = case when ? = 0 then category_id else ? end " +
            "and status = 1 " +
            "limit ? , ?;", nativeQuery = true)
    List<Content> findAllByCategoryId(int categoryId1, int categoryId2, int begin, int rows);

    @Query(value = "select count(id) from tb_content where status = 1 " +
            "and category_id = case when ? = 0 then category_id else ? end;", nativeQuery = true)
    int findTotal(int categoryId1, int categoryId2);
}
