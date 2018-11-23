package com.shopping.dev.search.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.utils.ResultWrapper;
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
        SolrQuery solrQuery = new SolrQuery();
        Map<String, Object> map = new HashMap<>();

        // 如果搜索条件不为空 则设置关键词 如果搜索条件为空 查询所有
        if (searchKeywords != null && !searchKeywords.equals("")) {
            // 设置搜索关键词
            solrQuery.setQuery("searchKeywords:" + searchKeywords);
            // 执行第一次查询 不带分页信息 查询符合条件所有数据
            QueryResponse response = solr.query(solrQuery);
            // 获取总数据长度
            Integer totalData = Math.toIntExact(response.getResults().getNumFound());
            // 判断总页数
            Integer totalPage = totalData / rows;
            // 当前页码从1开始 页码
            currentPage = currentPage <= 0 ? 1 : currentPage;
            totalPage = totalPage == 0 ? 1 : totalPage;
            currentPage = currentPage >= totalPage ? totalPage : currentPage;
            Integer start = (currentPage - 1) * rows;
            solrQuery.setStart(start);
            solrQuery.setRows(rows);
            List<Item> items = solr.query(solrQuery).getBeans(Item.class);
            map.put("list", items);
            map.put("totalPage", totalPage);
            map.put("keyword", searchKeywords);
            map.put("currentPage", currentPage);
            return ResultWrapper.success(map);
        } else {
            solrQuery.setQuery("*:*");
            QueryResponse response = solr.query(solrQuery);
            // 获取总数据长度
            Integer totalData = Math.toIntExact(response.getResults().getNumFound());
            // 判断总页数
            Integer totalPage = totalData / rows;
            // 当前页码从1开始 页码
            currentPage = currentPage <= 0 ? 1 : currentPage;
            totalPage = totalPage == 0 ? 1 : totalPage;
            currentPage = currentPage >= totalPage ? totalPage : currentPage;
            Integer start = (currentPage - 1) * rows;
            solrQuery.setStart(start);
            solrQuery.setRows(rows);
            List<Item> items = solr.query(solrQuery).getBeans(Item.class);
            map.put("list", items);
            map.put("totalPage", totalPage);
            map.put("keyword", searchKeywords);
            map.put("currentPage", currentPage);
            return ResultWrapper.success(map);
        }
    }
}
