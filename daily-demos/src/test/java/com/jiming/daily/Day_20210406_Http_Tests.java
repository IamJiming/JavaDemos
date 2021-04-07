package com.jiming.daily;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

/**
 * Http 测试类
 *
 * @author Mr.tjm
 * @date 2020-04-06 11:25
 */
public class Day_20210406_Http_Tests {

    @Test
    void all_process_T(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建Http请求
        StringEntity entity = new StringEntity("", "");
        String url = "";
        HttpPost req = new HttpPost(url);
        req.setEntity(entity);
        req.setHeader("Content-Type", "application/json;charset=XX");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(req);
            HttpEntity respEntity = response.getEntity();
            System.out.println("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
