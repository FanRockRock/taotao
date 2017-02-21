package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月21日 上午9:54:40 
 */
@Controller
public class PageController {
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
