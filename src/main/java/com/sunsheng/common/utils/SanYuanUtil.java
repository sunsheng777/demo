package com.sunsheng.common.utils;

import java.math.BigDecimal;

/**
 * 三元运算符工具类
 */
public class SanYuanUtil {
    /**
     * 参数转int型,接收object型参数，转字符向，如果是null或者空字符，就返回null，否则转int并返回
     * @param obj
     * @return
     */
    public Integer sytoInt(Object obj) {
        if (obj==null || obj ==""){
            return null;
        }else {
            return Integer.parseInt(obj.toString());
        }
    }

    /**
     * 转long型，接收Object型参数，如果是null或空字符，就返回null，否则转long型返回
     * @param obj
     * @return
     */
    public Long sytoLong(Object obj) {
        if (obj==null || obj ==""){
            return null;
        }else {
            return Long.parseLong(obj.toString());
        }
    }

    /**
     * 转字符型，接收Object型参数，如果是null或空字符，就返回null，否则转long型返回
     * @param obj
     * @return
     */
    public String sytoString(Object obj) {
        if (obj==null || obj ==""){
            return "";
        }else {
            return obj.toString();
        }
    }
    public BigDecimal sytoDecimal(Object obj){
        if (obj==null || obj==""){
            return null;
        }else {
            BigDecimal bigDecimal = new BigDecimal(obj.toString());
            return bigDecimal;
        }
    }
}
