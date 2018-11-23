package com.shopping.dev.search.controller;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.search.service.SearchService;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.awt.image.Kernel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Resource
    SearchService searchService;

    @ResponseBody
    @RequestMapping("/add")
    public void addBean() throws IOException, SolrServerException {
        searchService.addBean();
    }

    @RequestMapping("/solr")
    @ResponseBody
    public ResultWrapper
    solrSearch(@RequestParam(value = "keywords", defaultValue = "") String searchKeywords,
               @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
               @RequestParam(value = "rows", defaultValue = "20") Integer rows)
            throws IOException, SolrServerException {
        return searchService.solrSearch(searchKeywords, currentPage, rows);
    }
}