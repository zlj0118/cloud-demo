package com.shopping.dev.admincontroller;

import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.BaseRepository;
import com.shopping.dev.repository.BaseRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    // 内容分类管理,查询tb_content_category,返回表中全部内容集合
    @GetMapping("/content/category/list")
    public List<ContentCategory> findAllContentCategory() {
        return adminService.findAllContentCategory();
    }
}
