package com.taotao.search.controller;


import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/13.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/importall")
    @ResponseBody
    public TaotaoResult importAll() {
        try {
            TaotaoResult result = itemService.importItems();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtils.getStackTrace(e));
        }
    }

}

