package com.shopping.dev.repository;

import com.shopping.dev.entity.ContentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface AdminContentCategoryRepository extends JpaRepository<ContentCategory, Long> {
    @Modifying
    @Query(value = "update tb_content_category set is_parent = 1 where id = ?;", nativeQuery = true)
    int updateParent(long id);

    @Modifying
    @Query(value = "update tb_content_category set name = ?, updated = ? where id = ?;", nativeQuery = true)
    int updateName(String name, Timestamp updateTime, long id);

    @Query(value = "select count(parent_id) from tb_content_category where parent_id = ? and status <> 0;", nativeQuery = true)
    int findCountOfBrothersByParentId(long id);

    @Modifying
    @Query(value = "update tb_content_category set is_parent = 0 where id = ?", nativeQuery = true)
    void turnParentToChild(long parentId);

    @Modifying
    @Query(value = "update tb_content_category set status = 0 where parent_id = ?;", nativeQuery = true)
    void deleteChildren(long parentId);

    @Query(value = "select * from tb_content_category where parent_id = ?", nativeQuery = true)
    List<ContentCategory> findChildren(long parentId);

    @Modifying
    @Query(value = "update tb_content_category set status = 0 where id = ?;", nativeQuery = true)
    void deletePresent(long id);
}
