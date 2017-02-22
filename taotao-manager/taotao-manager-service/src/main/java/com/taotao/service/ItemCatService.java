package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月22日 上午10:39:30 
 */
public interface ItemCatService {
	public List<EasyUITreeNode> getItemCatList(Long parentId);
}
