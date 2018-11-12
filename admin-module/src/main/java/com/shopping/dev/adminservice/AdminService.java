package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategoryForEasyUiTree;
import com.shopping.dev.entity.ItemCartForEasyUiTree;
import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.Item;

import java.util.List;

public interface AdminService {
    List<Item> findAllItem(Integer page, Integer row);

    List<ItemCartForEasyUiTree> findAllItemCat(int id);

    List<ContentCategoryForEasyUiTree> findAllContentCategory(int id);


}
