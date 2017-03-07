package com.taotao.controller;

import com.taotao.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月20日 下午3:23:31 
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

    @RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId){
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){//Integer类型可以为空，int不行
		//ctrl+alt+B打开方法的接口实现
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
	}

    @RequestMapping(value="/item/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createItem(TbItem item,String desc){
        TaotaoResult result = itemService.createItem(item, desc);
        return result;
    }
}
