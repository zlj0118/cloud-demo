package com.shopping.dev.admincontroller;

import com.shopping.dev.adminservice.AdminService;
import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.repository.AdminRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/content")
public class AdminController {

    @Resource
    private AdminService adminService;
    @RequestMapping("/category/list")
    public List findAll() {
        return adminService.findAll();
    }
}
