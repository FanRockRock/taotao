package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;

/**
 * Created by Administrator on 2017/4/19.
 */
public interface ItemService {
    public TbItem getItemById(Long itemId) throws Exception;
    public TbItemDesc getItemDescById(Long itemId) throws Exception;
    public TbItemParamItem getItemParamById(Long itemId) throws Exception;
}
