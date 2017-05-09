package com.taotao.sso.service;

import com.taotao.common.pojo.TaotaoResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface LoginService {
    public TaotaoResult login(String username, String password, HttpServletRequest request,
                              HttpServletResponse response);

    public TaotaoResult getUserByToken(String token);
}
