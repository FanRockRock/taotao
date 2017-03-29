package com.taotao.portal.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/29.
 */

public class TestHttpClient {
    @Test
    public void testHttpPost() throws Exception {
        // 第一步：创建一个httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 第二步：创建一个HttpPost对象。需要指定一个url
        HttpPost post = new HttpPost("http://localhost:8082/posttest.html");
        // 第三步：创建一个list模拟表单，list中每个元素是一个NameValuePair对象
        List<NameValuePair> formList = new ArrayList<>();
        formList.add(new BasicNameValuePair("name", "张三"));
        formList.add(new BasicNameValuePair("pass", "1243"));
        // 第四步：需要把表单包装到Entity对象中。StringEntity
        StringEntity entity = new UrlEncodedFormEntity(formList, "utf-8");
        post.setEntity(entity);
        // 第五步：执行请求。
        CloseableHttpResponse response = httpClient.execute(post);
        // 第六步：接收返回结果
        HttpEntity httpEntity = response.getEntity();
        String result = EntityUtils.toString(httpEntity);
        System.out.println(result);
        // 第七步：关闭流。
        response.close();
        httpClient.close();
    }
}
