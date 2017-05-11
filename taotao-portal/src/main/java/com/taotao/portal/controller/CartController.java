package com.taotao.portal.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/cart/add/{itemId}")
    public String addCart(@PathVariable Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
        try {
            TaotaoResult result = cartService.addCart(itemId, num, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cartSuccess";
    }

    @RequestMapping("/cart/cart")
    public String showCartList(HttpServletRequest request, Model model) {
        List<CartItem> list = cartService.getCartItems(request);
        //把商品列表传递给jsp
        model.addAttribute("cartList", list);
        return "cart";
    }
}
