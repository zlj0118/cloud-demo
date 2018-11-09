package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
    List<Item> findAllItem(Integer page, Integer row);

    List<ContentCategory> findAllContentCategory();
}
