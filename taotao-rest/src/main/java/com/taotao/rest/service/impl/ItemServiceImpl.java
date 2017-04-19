package com.taotao.rest.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    @Autowired
    private JedisClient jedisClient;

    @Value("${REDIS_ITEM_KEY}")
    private String REDIS_ITEM_KEY;
    @Value("${ITEM_BASE_INFO_KEY}")
    private String ITEM_BASE_INFO_KEY;
    @Value("${ITEM_EXPIRE_SECOND}")
    private Integer ITEM_EXPIRE_SECOND;
    @Value("${ITEM_DESC_KEY}")
    private String ITEM_DESC_KEY;
    @Value("${ITEM_PARAM_KEY}")
    private String ITEM_PARAM_KEY;

    @Override
    public TbItem getItemById(Long itemId) throws Exception {
        //查缓存，有的话直接返回
        String json = jedisClient.get(REDIS_ITEM_KEY + ":" + ITEM_BASE_INFO_KEY + ":" + itemId);
        if (StringUtils.isNotBlank(json)) {
            //将Json转为Java对象
            TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
            return item;
        }
        //根据商品信息查ID，返回TbItem
        TbItem item = itemMapper.selectByPrimaryKey(itemId);

        //添加到缓存
        jedisClient.set(REDIS_ITEM_KEY + ":" + ITEM_BASE_INFO_KEY + ":" + itemId, JsonUtils.objectToJson(item));
        //设置过期时间
        jedisClient.expire(REDIS_ITEM_KEY + ":" + ITEM_BASE_INFO_KEY + ":" + itemId, ITEM_EXPIRE_SECOND);

        return item;
    }

    @Override
    public TbItemDesc getItemDescById(Long itemId) throws Exception {
        //查询缓存
        //查询缓存，如果有缓存，直接返回

        String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY);
        //判断数据是否存在
        if (StringUtils.isNotBlank(json)) {
            // 把json数据转换成java对象
            TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
            return itemDesc;
        }

        //根据商品id查询商品详情
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        //添加缓存

        //向redis中添加缓存
        jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY
                , JsonUtils.objectToJson(itemDesc));
        //设置key的过期时间
        jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY, ITEM_EXPIRE_SECOND);

        return itemDesc;

    }

    @Override
    public TbItemParamItem getItemParamById(Long itemId) throws Exception {
        //查询缓存
        String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY);
        //判断数据是否存在
        if (StringUtils.isNotBlank(json)) {
            // 把json数据转换成java对象
            TbItemParamItem itemParamitem = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
            return itemParamitem;
        }
        //根据商品Id查询规格参数
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if(list!=null&&list.size()>0){
            TbItemParamItem itemParamItem = list.get(0);
            //添加缓存
            //向redis中添加缓存
            jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY
                    , JsonUtils.objectToJson(itemParamItem));
            //设置key的过期时间
            jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY, ITEM_EXPIRE_SECOND);

            return itemParamItem;
        }

        return null;
    }
}
