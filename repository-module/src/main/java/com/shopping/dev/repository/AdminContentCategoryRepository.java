package com.shopping.dev.repository;

import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.ContentCategoryForEasyUiTree;
import com.shopping.dev.entity.ItemCartForEasyUiTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminContentCategoryRepository extends JpaRepository<ContentCategoryForEasyUiTree, Long> {
    @Query(value = " select id, name, parent_id, if (is_parent = 0, 'open', 'closed') " +
            "as state from tb_content_category;", nativeQuery = true)
    List<ContentCategoryForEasyUiTree> findContentCategory();

}
