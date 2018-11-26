package com.shopping.dev.repository;

import com.shopping.dev.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminContentRepository extends JpaRepository<Content, Long> {
    @Query(value = "select * from tb_content " +
            "where category_id = case when :categoryId = 0 then category_id else :categoryId end " +
            "and status = 1 " +
            "limit :beginSQL, :rowsSQL", nativeQuery = true)
    List<Content> findAllByCategoryId(@Param("categoryId") int categoryId, @Param("beginSQL")int begin, @Param("rowsSQL")int rows);

    @Query(value = "select count(id) from tb_content where status = 1 " +
            "and category_id = case when :categoryId = 0 then category_id else :categoryId end;", nativeQuery = true)
    int findTotal(@Param("categoryId")int categoryId);

    @Modifying
    @Query(value = "update tb_content set status = 0 where id in (:ids);", nativeQuery = true)
    int deleteContentByIds(@Param("ids") List<Long> ids);

    @Modifying
    @Query(value = "update tb_content set status = 0 where category_id = :categoryId", nativeQuery = true)
    int deleteContentByIds(@Param("categoryId") long categoryId);
}
