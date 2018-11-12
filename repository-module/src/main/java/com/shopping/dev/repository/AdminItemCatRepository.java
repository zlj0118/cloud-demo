package com.shopping.dev.repository;

import com.shopping.dev.entity.ItemCartForEasyUiTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminItemCatRepository extends JpaRepository<ItemCartForEasyUiTree, Long> {
    @Query(value = " select id, name, if (is_parent = 0, 'open', 'closed') as state from tb_item_cat where parent_id = ?;", nativeQuery = true)
    List<ItemCartForEasyUiTree> findItemCatByParentId(int id);
}
