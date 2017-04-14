package com.taotao.search.dao;

import com.taotao.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

/**
 * Created by Administrator on 2017/4/14.
 */
public interface SearchDao {
    public SearchResult search(SolrQuery query) throws Exception;
}
