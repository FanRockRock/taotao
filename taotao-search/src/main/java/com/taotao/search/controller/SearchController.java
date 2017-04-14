package com.taotao.search.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.pojo.SearchResult;
import com.taotao.search.service.SearchService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/14.
 * 搜索服务的url：/search/q?keyword=xxx&page=1&rows=30
 * 参数keyword、page、rows
 * 返回结果：json数据，使用TaotaoResult包装SearchResult。
 */
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/q")
    @ResponseBody
    public TaotaoResult search(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "30") Integer rows) {
        try {
            //get请求转换字符集
            keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
            SearchResult searchResult = searchService.search(keyword, page, rows);
            return TaotaoResult.ok(searchResult);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
        }

    }
}
