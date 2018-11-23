package com.shopping.dev.repository;

import com.shopping.dev.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "select * from tb_item where status <> 0 limit ? , ?;", nativeQuery = true)
    List<Item> findAllItem(int begin, int row);
    @Query(value = "select count(id) from tb_item;", nativeQuery = true)
    int findTotal();
    @Modifying
    @Query(value = "update tb_item set status = :statuz where id in (:ids)", nativeQuery = true)
    int changeStatusByIds(@Param("statuz") int statuz,@Param("ids") List<Long> ids);

}
