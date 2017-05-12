package com.github.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author williamfan
 */
public class HttpUtil {

    public static String requestJson(String url, String jsonParam) {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;


        StringEntity entity = new StringEntity(jsonParam, "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        System.out.println();

        HttpResponse resp = null;
        try {
            resp = client.execute(httpPost);
            if (resp.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = resp.getEntity();
                respContent = EntityUtils.toString(httpEntity, "UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return respContent;
    }

}
