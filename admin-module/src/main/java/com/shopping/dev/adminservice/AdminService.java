package com.shopping.dev.adminservice;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.entity.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public interface AdminService {
    //------------------------------查询商品-----------------------------------
    addTotalParams<Item> findAllItem(int page, int rows);

    List<ItemCartForEasyUiTree> findAllItemCat(int id);

    //-----------------------------规格参数-----------------------------------------
    addTotalParams<ItemParamAddItemCatName> findAllItemParam(int page, int rows);
    boolean findItemParamById(long id);
    boolean addItemParam(long item_cat_id, String paramData);
    boolean deleteItemParamByIds(List<Long> ids);

    //-------------------------内容分类管理------------------------------------
    List<ContentCategoryForEasyUiTree> findAllContentCategory();
    ContentCategory createOneOfCategory(long parentId, String name);
    int updateNameByCategoryId(String name, long id);
    boolean deleteOneByCategoryId(long id);

    addTotalParams<Content> findAllContent(int categoryId, int begin, int rows);

}
