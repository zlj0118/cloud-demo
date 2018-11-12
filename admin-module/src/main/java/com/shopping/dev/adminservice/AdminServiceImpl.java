package com.shopping.dev.adminservice;

import com.shopping.dev.entity.ContentCategoryForEasyUiTree;
import com.shopping.dev.entity.ItemCartForEasyUiTree;
import com.shopping.dev.entity.ContentCategory;
import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.AdminContentCategoryRepository;
import com.shopping.dev.repository.AdminItemCatRepository;
import com.shopping.dev.repository.AdminItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminContentCategoryRepository adminContentCategoryRepository;
    @Resource
    private AdminItemRepository adminItemRepository;
    @Resource
    private AdminItemCatRepository adminItemCatRepository;

    @Override
    public List<Item> findAllItem(Integer page, Integer row) {
        Pageable pageable =  PageRequest.of(page, row);
        return adminItemRepository.findAll(pageable).getContent();
    }

    @Override
    public List<ItemCartForEasyUiTree> findAllItemCat(int id) {
        return adminItemCatRepository.findItemCatByParentId(id);
    }



    @Override
    public List<ContentCategoryForEasyUiTree> findAllContentCategory(int id) {
        return adminContentCategoryRepository.findContentCategoryByParentId(id);
    }
}
