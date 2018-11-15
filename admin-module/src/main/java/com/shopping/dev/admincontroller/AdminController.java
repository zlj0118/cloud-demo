package com.shopping.dev.admincontroller;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    // 查询商品,查询tb_item
    @GetMapping("/item/list")
    public addTotalParams<Item> findAllItem(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "20")int rows) {
        return adminService.findAllItem(page, rows);
    }

    // 选择类目,查询tb_item_cat
    @PostMapping("/item/cat/list")
    public List<ItemCartForEasyUiTree> findAllItemCat(@RequestParam(defaultValue = "0") int id) {
        return adminService.findAllItemCat(id);
    }

    // 规格参数,多表查询
    @GetMapping("/item/param/list")
    public addTotalParams<ItemParamAddItemCatName> findAllItemParam(
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "10")int rows) {
        return adminService.findAllItemParam(page, rows);
    }

    // 内容分类管理,查询tb_content_category,返回表中全部内容集合
    @GetMapping("/content/category/list")
    public List<ContentCategoryForEasyUiTree> findAllContentCategory() {
        return adminService.findAllContentCategory();
    }

    // 内容管理,查询tb_content
    @GetMapping("content/query/list")
    public addTotalParams<Content> findAllContent(
            @RequestParam(defaultValue = "0")int categoryId,
            @RequestParam(defaultValue = "1")int page,
            @RequestParam(defaultValue = "10")int rows) {
        return adminService.findAllContent( categoryId, page, rows);
    }
}
