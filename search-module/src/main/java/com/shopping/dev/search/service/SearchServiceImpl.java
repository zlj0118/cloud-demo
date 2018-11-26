package com.shopping.dev.search.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.utils.ResultWrapper;
import com.shopping.dev.utils.SolrSearch;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Resource
    private SearchRepository searchRepository;
    @Resource
    private SolrClient solr;


    @Override
    public ResultWrapper findAll() {
        List<Item> itemList = searchRepository.findAll();
        return ResultWrapper.success(itemList);
    }

    @Override
    public void addBean() throws IOException, SolrServerException {
        solr.deleteByQuery("*:*");
        // 从数据库查出所有的user,UserService操作数据库部分的代码省略
        List<Item> items = searchRepository.findAll();
        // 添加
        solr.addBeans(items);
        solr.commit();
    }

    public ResultWrapper
    solrSearch(@RequestParam(value = "keywords", defaultValue = "") String searchKeywords,
               @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
               @RequestParam(value = "rows", defaultValue = "20") Integer rows)
            throws IOException, SolrServerException {
        return SolrSearch.orderSearch(searchKeywords, currentPage, rows, solr);
    }
}

