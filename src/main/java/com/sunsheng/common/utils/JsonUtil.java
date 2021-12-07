package com.sunsheng.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * json转换工具类
 */
public class JsonUtil {

    /**
     * 将对象装换成字符串
     * @param object
     * @return
     */
    public static String jsonToString(Object object){
       return JSON.toJSONString(object);
    }


    /**
     * 将字符串解析成数组
     * @return
     */
    public static  <T> List<T> parseArray(String json, Class<T> clazz){
        return JSON.parseArray(json,clazz);
    }
    /**
     listToTree
     方法说明

     将JSONArray数组转为树状结构
     @param arr 需要转化的数据
     @param id 数据唯一的标识键值
     @param pid 父id唯一标识键值
     @param child 子节点键值
     @return JSONArray
     */
    public static JSONArray listToTree(JSONArray arr, String id, String pid, String child){
        JSONArray r = new JSONArray();
        JSONObject hash = new JSONObject();
        //将数组转为Object的形式，key为数组中的id
        for(int i=0;i<arr.size();i++){
            JSONObject json = (JSONObject) arr.get(i);
            hash.put(json.getString(id), json);
        }
        //遍历结果集
        for(int j=0;j<arr.size();j++){
            //单条记录
            JSONObject aVal = (JSONObject) arr.get(j);
            //在hash中取出key为单条记录中pid的值
            JSONObject hashVP = (JSONObject) hash.get(aVal.get(pid).toString());
            //如果记录的pid存在，则说明它有父节点，将她添加到孩子节点的集合中
            if(hashVP!=null){
            //检查是否有child属性
                if(hashVP.get(child)!=null){
                    JSONArray ch = (JSONArray) hashVP.get(child);
                    ch.add(aVal);
                    hashVP.put(child, ch);
                }else{
                    JSONArray ch = new JSONArray();
                    ch.add(aVal);
                    hashVP.put(child, ch);
                }
            }else{
                r.add(aVal);
            }
        }
        return r;
    }
}
