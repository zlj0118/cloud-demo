package com.shopping.dev.order.controller;

import com.shopping.dev.order.service.OrderService;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("/all")
    public ResultWrapper allOrder(@RequestParam(name = "userId") Long userId) {
        ResultWrapper orders = orderService.findAll(userId);
        return orders;
    }

    @RequestMapping("/delete")
    public ResultWrapper deleteOne(@RequestParam(name = "orderId") String orderId) {
        return orderService.deleteByOrderId(orderId);
    }

    @RequestMapping("/search")
    public ResultWrapper
    searchOrder(@RequestParam(value = "keywords", defaultValue = "") String searchKeywords,
                @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                @RequestParam(value = "rows", defaultValue = "20") Integer rows)
            throws IOException, SolrServerException {
        return orderService.orderSearch(searchKeywords, currentPage, rows);
    }
}
