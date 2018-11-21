package com.shopping.dev.search.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private SearchRepository searchRepository;


    @Override
    public ResultWrapper findAll() {

        List<Item> itemList = searchRepository.findAll();
        return ResultWrapper.success(itemList);
    }
}
