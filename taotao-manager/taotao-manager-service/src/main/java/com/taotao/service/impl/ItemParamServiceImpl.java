package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{
    @Autowired
    private TbItemParamMapper itemParamMapper;
    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        //根据cid查询规格参数模板
        TbItemParamExample tbItemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = tbItemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        //执行查询
        List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(tbItemParamExample);
        //判断是否查询到结果
        if(tbItemParams!=null&&tbItemParams.size()>0){
            TbItemParam tbItemParam = tbItemParams.get(0);
            return TaotaoResult.ok(tbItemParam);
        }
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {
        //创建一个pojo
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        //插入记录
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }
}
