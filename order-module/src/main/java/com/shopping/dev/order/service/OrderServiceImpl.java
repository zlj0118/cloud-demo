package com.shopping.dev.order.service;

import com.shopping.dev.entity.Item;
import com.shopping.dev.entity.Order;
import com.shopping.dev.repository.OrderRepository;
import com.shopping.dev.repository.SearchRepository;
import com.shopping.dev.utils.ResultWrapper;
import com.shopping.dev.utils.SolrSearch;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderRepository orderRepository;

    @Resource
    private SolrClient solr;

    @Override
    public ResultWrapper findAll(Long userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return ResultWrapper.success(orders);
    }


    @Override
    public ResultWrapper deleteByOrderId(String orderId) {
        try {
            orderRepository.deleteByOrderId(orderId);
            return ResultWrapper.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(400, "删除失败");
        }
    }

    @Override
    public ResultWrapper
    orderSearch(@RequestParam(value = "keywords", defaultValue = "") String searchKeywords,
                @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                @RequestParam(value = "rows", defaultValue = "20") Integer rows)
            throws IOException, SolrServerException {
        return SolrSearch.orderSearch(searchKeywords, currentPage, rows, solr);
    }

}
