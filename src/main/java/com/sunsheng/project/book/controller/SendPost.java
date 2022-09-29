package com.sunsheng.project.book.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author PC
 */
public class SendPost {

    public JSONObject post1() {
        //定义发送数据
        JSONObject param = new JSONObject();
        param.put("cbid", "22519934901664304");
        String[] s = {"60451815300765326"};
        param.put("ccids", s);
        //定义接收数据
        JSONObject result = new JSONObject();

        String url = "https://www.xxsypro.com/api/book/auth/download/v2/chapters";
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        //请求参数转JOSN字符串
        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        try {
            HttpResponse response = client.execute(httpPost);
            int recode = 200;
            if (response.getStatusLine().getStatusCode() == recode) {
                result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
        return result;
    }
}
