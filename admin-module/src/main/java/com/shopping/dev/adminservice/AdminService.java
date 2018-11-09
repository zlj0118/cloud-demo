package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategory;

import java.util.List;

public interface AdminService {
    List<ContentCategory> findAll();
}
