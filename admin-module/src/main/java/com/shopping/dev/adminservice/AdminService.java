package com.shopping.dev.adminservice;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.entity.*;
import com.shopping.dev.resultwrapper.MyResultWrapper;

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
    boolean createOneOfCategory(long parentId, String name);
    boolean updateNameByCategoryId(String name, long id);
    boolean deleteOneByCategoryId(long id);

    //-------------------------------内容管理------------------------------------
    addTotalParams<Content> findAllContent(int categoryId, int begin, int rows);
    boolean deleteContentByIds(List<Long> ids);
    boolean updateOrCreateContentById(Content content);

}
