package com.shopping.dev.search.service;

import com.shopping.dev.utils.ResultWrapper;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SearchService {

    ResultWrapper findAll();

    void addBean() throws IOException, SolrServerException;

    ResultWrapper solrSearch(String searchKeywords, Integer currentPage, Integer rows) throws IOException, SolrServerException;
}
