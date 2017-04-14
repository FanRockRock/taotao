package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * Created by Administrator on 2017/3/24.
 * 访问首页
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value="/posttest",method = RequestMethod.POST)
    @ResponseBody
    public String testHttpClient(String name,String pass){
        System.out.println(name+":"+pass);
        return "OK";
    }
}
