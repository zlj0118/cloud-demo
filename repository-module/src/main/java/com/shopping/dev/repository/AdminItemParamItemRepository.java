package com.shopping.dev.repository;

import com.shopping.dev.entity.ItemParamItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminItemParamItemRepository extends JpaRepository<ItemParamItem, Long> {
    ItemParamItem findByItemId(long itemId);

    @Modifying
    @Query(value = "update tb_item_param_item set param_data = :itemParams " +
            "where id = :itemParamId", nativeQuery = true)
    int updateItemParamItemBy(@Param("itemParams") String itemParams, @Param("itemParamId") long itemParamId);
}
