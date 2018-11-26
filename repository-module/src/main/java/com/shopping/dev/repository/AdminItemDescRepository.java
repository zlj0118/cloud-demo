package com.shopping.dev.repository;

import com.shopping.dev.entity.ItemDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface AdminItemDescRepository extends JpaRepository<ItemDesc, Long> {
    @Modifying
    @Query(value = "update tb_item_desc set " +
            "item_desc = :desc, " +
            "updated = :updated" +
            " where item_id = :itemId", nativeQuery = true)
    int updateItemDescByItemId(@Param("itemId") long itemId,
                               @Param("updated")Timestamp updated,
                               @Param("desc")String desc);
}
