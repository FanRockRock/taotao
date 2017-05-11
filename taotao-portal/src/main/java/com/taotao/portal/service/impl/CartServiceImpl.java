package com.taotao.portal.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import com.taotao.portal.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/11.
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private ItemService itemService;
    @Value("${COOKIE_EXPIRE}")
    private Integer COOKIE_EXPIRE;

    @Override
    public TaotaoResult addCart(Long itemId, Integer num, HttpServletRequest request, HttpServletResponse response) {
        //查询cookie中的商品列表
        List<CartItem> cartItemList = getCartItemList(request);
        boolean flag=false;
        //通过商品id查看是否有此商品
        for(CartItem item:cartItemList){
            if(item.getId().longValue()==itemId.longValue()){
                item.setNum(item.getNum()+num);
                flag=true;
                break;
            }
        }
        //若不存在，调用rest服务，通过id获得商品，存入cookie
        if(!flag){
            TbItem item = itemService.getItemById(itemId);
            CartItem cartItem = new CartItem();
            cartItem.setId(itemId);
            cartItem.setNum(num);
            cartItem.setPrice(item.getPrice());
            cartItem.setTitle(item.getTitle());
            if (StringUtils.isNotBlank(item.getImage())) {
                String image = item.getImage();
                String[] strings = image.split(",");
                cartItem.setImage(strings[0]);
            }
            //添加到购物车商品列表
            // 6、把商品数据添加到列表中
            cartItemList.add(cartItem);
        }
        // 7、把购物车商品列表写入cookie
        CookieUtils.setCookie(request, response, "TT_CART", JsonUtils.objectToJson(cartItemList), COOKIE_EXPIRE, true);
        // 8、返回TaotaoResult
        return TaotaoResult.ok();
    }

    @Override
    public List<CartItem> getCartItems(HttpServletRequest request) {
        List<CartItem> list = getCartItemList(request);
        return list;
    }

    /**
     * 从cookie中取商品列表
     */
    public List<CartItem> getCartItemList(HttpServletRequest request){
        try {
            //从cookie中取商品列表
            String json = CookieUtils.getCookieValue(request, "TT_CART", true);
            //把json转换成java对象
            List<CartItem> list = JsonUtils.jsonToList(json, CartItem.class);

            return list==null?new ArrayList<CartItem>():list;
        } catch (Exception e) {
            return new ArrayList<CartItem>();
        }
    }
}
