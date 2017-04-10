package com.taotao.jedis;

import com.taotao.rest.component.JedisClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/10.
 */
public class JedisTest {
    @Test
    public void testJedisClientSpring(){
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从容器中获得JedisClient对象
        JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
        //jedisClient操作redis
        jedisClient.set("cliet1", "1000");
        String string = jedisClient.get("cliet1");
        System.out.println(string);
    }
}
