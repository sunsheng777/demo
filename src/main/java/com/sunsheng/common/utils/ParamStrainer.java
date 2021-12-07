package com.sunsheng.common.utils;

import java.util.Map;

public class ParamStrainer {
    /*
     * 把参数中的String 解析 成 Integer 在放入params
     */
    public static void parseInt(Map<String, Object> params,String... keys){
        for (String key : keys) {
            Object param = params.get(key);
            if(param != null && !param.equals("") && params.get(key) != null && !params.get(key).equals("")){
                params.put(key,Integer.parseInt(param.toString()));
            }
        }
    }
    public static void parseBoolean(Map<String, Object> params,String... keys){
        for (String key : keys) {
            Object param = params.get(key);
            if(param != null && !param.equals("") && params.get(key) != null && !params.get(key).equals("")){
                params.put(key,Boolean.parseBoolean(param.toString()));
            }
        }
    }
}
