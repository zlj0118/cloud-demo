package com.shopping.dev.search.controller;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.search.service.SearchService;
import com.shopping.dev.utils.FileUpload;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Resource
    SearchService searchService;

    @Resource
    SearchRepository searchRepository;

    @Resource
    private SolrClient solr;


    @RequestMapping("/all")
    @ResponseBody
    public ResultWrapper searchAll() {
        return searchService.findAll();
    }

    @ResponseBody
    @RequestMapping("/add")
    public void addBean() throws IOException, SolrServerException {
        solr = new HttpSolrClient.Builder("http://localhost:8983/solr/search").build();
        // 从数据库查出所有的user,UserService操作数据库部分的代码省略
        List<Item> items = searchRepository.findAll();
        // 添加
        solr.addBeans(items);
        solr.commit();

    }

    @RequestMapping("/solr")
    @ResponseBody
    public List<Item> solrSearch() throws IOException, SolrServerException {

        solr = new HttpSolrClient.Builder("http://localhost:8983/solr/search").build();
        // 构造搜索条件
        SolrQuery solrQuery = new SolrQuery();

        // 设置搜索关键词
        solrQuery.setQuery("price:1100");

        // 设置分页信息
        solrQuery.setStart(0);
        solrQuery.setRows(6);
        System.out.println(solrQuery);
        // 执行查询
        QueryResponse response = solr.query(solrQuery);
        System.out.println(response);

        // 获取查询结果
        List<Item> itemsList = response.getBeans(Item.class);
        return itemsList;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value = "image") MultipartFile file) throws Exception {
        String s = FileUpload.fileUpload(file);
        System.out.println(s);
        return s;
    }
}