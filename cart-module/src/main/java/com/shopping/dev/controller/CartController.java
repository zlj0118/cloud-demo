package com.shopping.dev.controller;

import com.shopping.dev.entity.Item;
import com.shopping.dev.entity.Order;
import com.shopping.dev.param.CreateOrder;
import com.shopping.dev.param.ItemDel;
import com.shopping.dev.param.ItemParam;
import com.shopping.dev.service.CartService;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * 创建 JYQ  on  2018/11/8,13:34
 */
@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    private CartService cartService;

    @PostMapping("/buy")
    public Object buy( @RequestBody ItemParam itemParam) {
        this.cartService.buy(itemParam);
        return null;
    }

    @GetMapping("/showCart")
    public ResultWrapper showCart(Long userId) {
        System.out.println("1234567" + userId);
        List<?> showCart = this.cartService.showCart(userId);
//        System.out.println(showCart);
        return ResultWrapper.success(showCart);
    }

    @GetMapping("/update/num")
    public String setT0tal(Integer itemNum, Long itemId) {
//        System.out.println("接到 itemNum:" + itemNum + "itemId:" + itemId);
        String s = this.cartService.setTotal(itemNum, itemId);
        return s;

    }

    //  删除
    @GetMapping("/delete")
    public Long delete(ItemParam itemParam) {
        Long isDel = this.cartService.delete(itemParam);
        return isDel;
    }

    // 删除选中
    @GetMapping("/deleteChecked")
    public void deleteChecked(String list) {
//        System.out.println(list);
        this.cartService.deleteChecked(list);
    }

    @GetMapping("/goodContent")
    public ResultWrapper goodContent(Long itemId) {
        Item item = this.cartService.goodContent(itemId);
        return ResultWrapper.success(item);
    }

    @GetMapping("/commitOrder")
    public ResultWrapper commitOrder(String itemIdList) {
        List<?> list = this.cartService.commitOrder(itemIdList);
        return ResultWrapper.success(list);
    }

    @PostMapping("/createOrder")
    public ResultWrapper createOrder(@RequestBody CreateOrder createOrder) {
        System.out.println(createOrder);
        this.cartService.createOrder(createOrder);
        return ResultWrapper.success(createOrder);
    }


}
