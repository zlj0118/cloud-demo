package com.shopping.dev.adminservice;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.entity.*;
import com.shopping.dev.repository.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminContentCategoryRepository adminContentCategoryRepository;
    @Resource
    private AdminItemRepository adminItemRepository;
    @Resource
    private AdminItemCatRepository adminItemCatRepository;
    @Resource
    private AdminItemParamRepository adminItemParamRepository;
    @Resource
    private AdminContentRepository adminContentRepository;

    @Override
    public addTotalParams<Item> findAllItem(int page, int rows) {
        int begin = (page - 1) * rows;
        List<Item> items = adminItemRepository.findAllItem(begin, rows);
        System.out.println(items.get(0));
        int total = adminItemRepository.findTotal();
        return new addTotalParams<>(items, total);
    }

    @Override
    public List<ItemCartForEasyUiTree> findAllItemCat(int id) {
        return adminItemCatRepository.findItemCatByParentId(id);
    }

    @Override
    public addTotalParams<ItemParamAddItemCatName> findAllItemParam(int page, int rows) {
        int begin = (page - 1) * rows;
        List<ItemParamAddItemCatName> itemParams = adminItemParamRepository.findAllParam(begin, rows);
        int total = adminItemParamRepository.findTotal();
        return new addTotalParams<>(itemParams, total);
    }


    @Override
    public List<ContentCategoryForEasyUiTree> findAllContentCategory() {
        List<ContentCategoryForEasyUiTree> list = adminContentCategoryRepository.findContentCategory();
        int toIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("closed".equals(list.get(i).getState())) {
                list.get(i).setState("open");
                List<ContentCategoryForEasyUiTree> temp = new ArrayList<>();
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).getId() == list.get(j).getParentId()) {
                        temp.add(list.get(j));
                    }
                }
                list.get(i).setChildren(temp);
            }
            if (list.get(i).getParentId() == 0) toIndex++;
        }
        if (toIndex > 0) return list.subList(0, toIndex);
        else return null;
    }

    @Override
    public addTotalParams<Content> findAllContent(int categoryId, int page, int rows) {
        List<Content> contents;
        int total;
        if (categoryId == 0) {
            Pageable pageable = PageRequest.of(--page, rows);
            contents = adminContentRepository.findAll(pageable).getContent();
            total = adminContentRepository.findTotal();
        } else {
            int begin = (page - 1) * rows;
            contents = adminContentRepository.findAllByCategoryId(categoryId, begin, rows);
            System.out.println(begin);
            total = adminContentRepository.findTotal();
        }
        return new addTotalParams<>(contents, total);
    }
}
