package com.shopping.dev.admincontroller;

import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.ContentCategoryForEasyUiTree;
import com.shopping.dev.entity.Item;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.Column;
import java.util.List;

@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    // 查询商品,查询tb_item
    @GetMapping("/item/list")
    public List<Item> findAllItem(Integer page, Integer rows) {
        return adminService.findAllItem(page, rows);
    }

    // 选择类目,查询tb_item_cat
    @PostMapping("/item/cat/list")
    public List findAllItemCat(@RequestParam(defaultValue = "0") int id) {
        return adminService.findAllItemCat(id);
    }

    // 内容分类管理,查询tb_content_category,返回表中全部内容集合
    @GetMapping("/content/category/list")
    public List<ContentCategoryForEasyUiTree> findAllContentCategory(@RequestParam(defaultValue = "0") int id) {
        return adminService.findAllContentCategory(id);
    }
}
