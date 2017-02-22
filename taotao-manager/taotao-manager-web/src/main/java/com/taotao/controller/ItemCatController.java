package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月22日 上午11:05:39 
 */
@Controller
@RequestMapping("item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService ItemCatService;
	@RequestMapping("list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<EasyUITreeNode> list = ItemCatService.getItemCatList(parentId);
		return list;
	}
}
