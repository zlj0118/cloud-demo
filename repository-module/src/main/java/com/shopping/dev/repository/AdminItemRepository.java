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

    @Modifying
    @Query(value = "insert into tb_item (title, sell_point, price, num, barcode, image, cid, created) " +
            "values (:#{#item.title}, :#{#item.sellPoint}, :#{#item.price}, :#{#item.num}, :#{#item.barcode}, " +
            ":#{#item.image}, :#{#item.cid}, :#{#item.created})", nativeQuery = true)
    int addItem(@Param("item") Item item);

    @Modifying
    @Query(value = "update tb_item set " +
            "title = :#{#item.title}, " +
            "sell_point = :#{#item.sellPoint}, " +
            "price = :#{#item.price}, " +
            "num = :#{#item.num}, " +
            "barcode = :#{#item.barcode}, " +
            "image = :#{#item.image}, " +
            "cid = :#{#item.cid}, " +
            "updated = :#{#item.updated} " +
            "where id = :#{#item.id}", nativeQuery = true)
    int updateItemById(@Param("item") Item item);
}
