package com.shopping.dev.order.service;

import com.shopping.dev.utils.ResultWrapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface OrderService {

    ResultWrapper findAll(Long userId);

    ResultWrapper deleteByOrderId(String orderId);

    ResultWrapper orderSearch(String searchKeywords, Integer currentPage, Integer rows)
            throws IOException, SolrServerException;
}
