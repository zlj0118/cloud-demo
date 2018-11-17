package com.shopping.dev.admincontroller;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.*;
import com.shopping.dev.resultwrapper.MyResultWrapper;
import com.shopping.dev.utils.ResultWrapper;
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

    //------------------------------查询商品-----------------------------------
    // 查询商品,查询tb_item
    @GetMapping("/item/list")
    public addTotalParams<Item> findAllItem(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int rows) {
        return adminService.findAllItem(page, rows);
    }

    // 选择类目,查询tb_item_cat
    @PostMapping("/item/cat/list")
    public List<ItemCartForEasyUiTree> findAllItemCat(@RequestParam(defaultValue = "0") int id) {
        return adminService.findAllItemCat(id);
    }


    //-----------------------------规格参数-----------------------------------------
    // 规格参数,多表查询
    @GetMapping("/item/param/list")
    public addTotalParams<ItemParamAddItemCatName> findAllItemParam(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows) {
        return adminService.findAllItemParam(page, rows);
    }


    //-------------------------内容分类管理------------------------------------
    // 查询tb_content_category,返回表中全部内容集合
    @GetMapping("/content/category/list")
    public List<ContentCategoryForEasyUiTree> findAllContentCategory() {
        return adminService.findAllContentCategory();
    }

    // 新增
    @PostMapping("/content/category/create")
    public MyResultWrapper createOneOfCategory(long parentId, String name) {
        ContentCategory category = adminService.createOneOfCategory(parentId, name);
        if (category == null) return MyResultWrapper.error();
        else return MyResultWrapper.success(category);
    }

    // 更改
    @PostMapping("content/category/update")
    public MyResultWrapper updateNameByCategoryId(String name, long id) {
        return MyResultWrapper.success(adminService.updateNameByCategoryId(name, id));
    }

    //删除
    @PostMapping("content/category/delete")
    public MyResultWrapper deleteOneByCategoryId(long id) {
        if (adminService.deleteOneByCategoryId(id)) return MyResultWrapper.success();
        else return MyResultWrapper.error();
    }

    // 内容管理,查询tb_content
    @GetMapping("content/query/list")
    public addTotalParams<Content> findAllContent(
            @RequestParam(defaultValue = "0") int categoryId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows) {
        return adminService.findAllContent(categoryId, page, rows);
    }
}
