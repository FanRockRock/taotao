package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

/** 
 * 类说明 
 * @author wangfan 
 * @version 创建时间：2017年2月22日 上午10:42:03 
 */
@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper itemCatMapper;
	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		//根据parentID查询分类列表
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//转换成List<EasyUITreeNode>
		List<EasyUITreeNode> result=new ArrayList<EasyUITreeNode>();
		for(TbItemCat item:list){
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(item.getId());
			node.setText(item.getName());
			node.setState(item.getIsParent()? "closed":"open");
			//添加
			result.add(node);
		}
		return result;
	}
}
