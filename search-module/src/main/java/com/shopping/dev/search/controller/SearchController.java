package com.shopping.dev.search.controller;

import com.shopping.dev.entity.Item;
import com.shopping.dev.repository.SearchRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Resource
    SearchRepository searchRepository;

    @RequestMapping("/all")
    @ResponseBody
    public List<Item> searchAll() {
        return searchRepository.findAll();
    }
//
//    @ResponseBody
//    @RequestMapping("/search")
//    public String search() {
//        return "search.html";
//    }

}
