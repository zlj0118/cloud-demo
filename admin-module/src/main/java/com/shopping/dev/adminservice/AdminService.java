package com.shopping.dev.adminservice;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.entity.*;

import java.util.List;

public interface AdminService {
    addTotalParams<Item> findAllItem(int page, int rows);

    List<ItemCartForEasyUiTree> findAllItemCat(int id);

    addTotalParams<ItemParamAddItemCatName> findAllItemParam(int page, int rows);

    List<ContentCategoryForEasyUiTree> findAllContentCategory();

    addTotalParams<Content> findAllContent(int categoryId, int begin, int rows);

}
