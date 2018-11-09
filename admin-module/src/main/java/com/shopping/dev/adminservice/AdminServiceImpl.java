package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.AdminContentCategoryRepository;
import com.shopping.dev.repository.AdminItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminContentCategoryRepository adminContentCategoryRepository;
    @Resource
    private AdminItemRepository adminItemRepository;

    @Override
    public List<Item> findAllItem(Integer page, Integer row) {
        Pageable pageable =  PageRequest.of(page, row);
//        Page<Item> all = adminItemRepository.findAll(pageable);
//        List<Item> content = all.getContent();
        return adminItemRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ContentCategory> findAllContentCategory() {
        return adminContentCategoryRepository.findAll();
    }
}
