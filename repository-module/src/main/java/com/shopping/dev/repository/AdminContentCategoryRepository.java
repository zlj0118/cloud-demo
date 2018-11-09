package com.shopping.dev.repository;

import com.shopping.dev.entity.ContentCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminContentCategoryRepository extends JpaRepository<ContentCategory, Long> {
}
