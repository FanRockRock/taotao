package com.taotao.portal.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by Administrator on 2017/4/20.
 */
public interface StaticPageService {
    public TaotaoResult genItemHtml(Long itemId) throws Exception;
}
