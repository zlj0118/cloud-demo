package com.shopping.dev.repository;

import com.shopping.dev.entity.ItemParam;
import com.shopping.dev.entity.ItemParamAddItemCatName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminItemParamRepository extends JpaRepository<ItemParam, Long> {
    @Query(value = "select param.id, param.item_cat_id as itemCatId, param.param_data as paramData, param.updated, param.created, cat.name as itemCatName " +
            "from tb_item_param param " +
            "left join tb_item_cat cat " +
            "on param.item_cat_id = cat.id limit ? , ?;",nativeQuery = true)
    List<ItemParamAddItemCatName> findAllParam(int begin, int rows);
    @Query(value = "select count(id) from tb_item_param;", nativeQuery = true)
    int findTotal();
}
