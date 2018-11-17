package com.shopping.dev.adminservice;

import com.shopping.dev.admincontroller.addparams.addTotalParams;
import com.shopping.dev.entity.*;
import com.shopping.dev.repository.*;
import com.shopping.dev.utils.GetTime;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminContentCategoryForEasyUITreeRepository adminContentCategoryForEasyUITreeRepository;
    @Resource
    private AdminItemRepository adminItemRepository;
    @Resource
    private AdminItemCatRepository adminItemCatRepository;
    @Resource
    private AdminItemParamRepository adminItemParamRepository;
    @Resource
    private AdminContentRepository adminContentRepository;
    @Resource
    private AdminContentCategoryRepository adminContentCategoryRepository;

    //------------------------------查询商品-----------------------------------
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

    //-----------------------------规格参数-----------------------------------------
    @Override
    public addTotalParams<ItemParamAddItemCatName> findAllItemParam(int page, int rows) {
        // 将前段页数,条数转换成limit参数
        int begin = (page - 1) * rows;
        List<ItemParamAddItemCatName> itemParams = adminItemParamRepository.findAllParam(begin, rows);
        // 查询总条数
        int total = adminItemParamRepository.findTotal();
        return new addTotalParams<>(itemParams, total);
    }


    //-------------------------内容分类管理------------------------------------
    // 查询
    @Override
    public List<ContentCategoryForEasyUiTree> findAllContentCategory() {
        List<ContentCategoryForEasyUiTree> list = adminContentCategoryForEasyUITreeRepository.findContentCategory();
        int toIndex = 0;
        // 按照easyUI格式组建层次
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
        // 取出parentID为0的前几条
        if (toIndex > 0) return list.subList(0, toIndex);
        else return null;
    }

    // 增加
    @Override
    @Transactional
    public ContentCategory createOneOfCategory(long parentId, String name) {
        int i = adminContentCategoryRepository.updateParent(parentId);
        if (i > 0) {
            ContentCategory category = new ContentCategory(parentId, name, 1L, 1L, 0L, GetTime.now(), null);
            return adminContentCategoryRepository.saveAndFlush(category);
        } else {
            return null;
        }
    }

    // 更改
    @Override
    @Transactional
    public int updateNameByCategoryId(String name, long id) {
        return adminContentCategoryRepository.updateName(name, GetTime.now(), id);
    }

    // 删除
    @Override
    @Transactional
    public boolean deleteOneByCategoryId(long id) {
        Optional<ContentCategory> categoryRepositoryById = adminContentCategoryRepository.findById(id);

        if (categoryRepositoryById.isPresent()) {
            ContentCategory category = categoryRepositoryById.get();
            // 判断删除项是否为父级,是父级则删除自己及所有子项,并将自己的is_parent值改为0;不是父级仅删除自身
            delete(category, id);

            // 判断父级是否删空,如果父级删空,将父级的is_parent改为0
            Long parentId = category.getParentId();
            int countBrothers = adminContentCategoryRepository.findCountOfBrothersByParentId(parentId);
            if (countBrothers == 0) {
                adminContentCategoryRepository.turnParentToChild(parentId);
            }
            return true;
        } else {
            return false;
        }
    }

    private void delete(ContentCategory category, long id) {
        if (category.getIsParent() == 1) {
            adminContentCategoryRepository.turnParentToChild(id);
            List<ContentCategory> children = adminContentCategoryRepository.findChildren(id);
            for (ContentCategory child : children) {
                delete(child, child.getId());
            }
            // 删除所有子标签
            adminContentCategoryRepository.deleteChildren(id);
        }
        // 删除当前标签
        adminContentCategoryRepository.deletePresent(id);
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
