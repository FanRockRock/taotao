package com.taotao.portal.service;


import com.taotao.portal.pojo.SearchResult;

/**
 * Created by Administrator on 2017/4/14.
 */
public interface SearchService {
    public SearchResult search(String keyword, int page, int rows);
}
