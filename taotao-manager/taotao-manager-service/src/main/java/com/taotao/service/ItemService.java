package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.pojo.TbItem;

/** 
 * 项目表接口
 * @author wangfan 
 * @version 创建时间：2017年2月20日 下午3:16:24 
 */
public interface ItemService {
	public TbItem getItemById(Long itemId);
	
	public EasyUIDataGridResult getItemList(int page,int rows);
}
