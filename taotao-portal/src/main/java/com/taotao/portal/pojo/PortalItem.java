package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;
import org.apache.commons.lang3.StringUtils;

/**
 * 这个类的作用是由于前端使用了item.images，使用了TbItem的一个不存在的属性，因此需要写这个类继承TbItem，而不改变原来的pojo
 * Created by Administrator on 2017/4/19.
 */
public class PortalItem extends TbItem {
    public String[] getImages(){
        String images=this.getImage();
        if(StringUtils.isNotBlank(images)){
            String[] imgs = images.split(",");
            return imgs;
        }
        return null;
    }
}
