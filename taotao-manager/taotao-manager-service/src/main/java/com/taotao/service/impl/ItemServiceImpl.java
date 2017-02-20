package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月20日 下午3:18:40 
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(Long itemId) {
		TbItem item = null;
		item=itemMapper.selectByPrimaryKey(itemId);
		return item;
	}

}
