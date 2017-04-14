package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * Created by Administrator on 2017/4/14.
 */
public interface SearchService {
    public SearchResult search(String queryString,int page,int rows) throws Exception;
}
