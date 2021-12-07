package com.sunsheng.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Query<T> {
    public static final String PAGE = "page";
    public static final String LIMIT = "limit";//每页显示记录数
    public static final String ORDER_FIELD = "sidx";//排序字段
    public static final String ORDER = "order";//排序方式
    public static final String ASC = "asc";//升序
    /**
     * SQL注入过滤
     * @param str
     * @return
     */
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");
        //转换成小写
        str = str.toLowerCase();
        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};
//
        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                new Exception("非法条件");
            }
        }

        return str;
    }
    public IPage<T> getPage(Map<String, Object> params) {
        return this.getPage(params, null, false);
    }

    public IPage<T> getPage(Map<String, Object> params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;//
        long limit = 10;
        if (params.get(PAGE) != null) {
            curPage = Long.parseLong((String)params.get(PAGE));
        }
        if (params.get(LIMIT) != null) {
            limit = Long.parseLong((String)params.get(LIMIT));
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
        params.put(PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = sqlInject((String)params.get(ORDER_FIELD));
        String order = (String)params.get(ORDER);

        //字段排序
        if (StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)) {
            if (ASC.equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            } else {
                return page.setDesc(orderField);
            }
        }

        //默认排序
//        if (isAsc) {
//            page.setAsc(defaultOrderField);
//        } else {
//            page.setDesc(defaultOrderField);
//        }

        return page;
    }
}
