package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by Administrator on 2017/3/8.
 */
public interface ItemParamService {
    public TaotaoResult getItemParamByCid(Long cid);

    public TaotaoResult insertItemParam(Long cid,String paramData);
}
