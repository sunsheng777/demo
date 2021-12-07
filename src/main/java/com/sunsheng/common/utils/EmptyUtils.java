package com.sunsheng.common.utils;

/**
 * 字符串空数据判断类
 */
public class EmptyUtils {

    public static boolean isEmpty(Object obj){
        if(obj == null){
            return true;
        }
        if(obj instanceof String){
            if(obj == "" ){
                return true;
            }
        }
        return false;
    }
}
