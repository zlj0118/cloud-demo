package com.shopping.dev.repository;

import com.shopping.dev.entity.ContentCategoryForEasyUiTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminContentCategoryForEasyUITreeRepository extends JpaRepository<ContentCategoryForEasyUiTree, Long> {
    @Query(value = " select id, name, parent_id, if (is_parent = 0, 'open', 'closed') " +
            "as state from tb_content_category " +
            "where status = 1 " +
            "order by parent_id ,sort_order;", nativeQuery = true)
    List<ContentCategoryForEasyUiTree> findContentCategory();

}
