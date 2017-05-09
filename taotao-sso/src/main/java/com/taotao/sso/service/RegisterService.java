package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbUser;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface RegisterService {
    public TaotaoResult checkData(String param,int type);
    public TaotaoResult register(TbUser user);
}
