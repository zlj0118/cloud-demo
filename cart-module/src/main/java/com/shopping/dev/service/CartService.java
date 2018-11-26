package com.shopping.dev.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.param.CreateOrder;
import com.shopping.dev.param.ItemDel;
import com.shopping.dev.param.ItemParam;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 创建 JYQ  on  2018/11/8,15:03
 */

public interface CartService {
    Object buy(ItemParam itemParam);

    List<?> showCart(Long userId);

    String setTotal(Integer itemNum, Long itemId);

    Long delete(ItemParam itemParam);

    void deleteChecked(String list);

    Item goodContent(Long itemId);

    List<?> commitOrder(String itemIdList);

    void createOrder(CreateOrder createOrder);
}
