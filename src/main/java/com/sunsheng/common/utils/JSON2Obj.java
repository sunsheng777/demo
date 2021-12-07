package com.sunsheng.common.utils;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
//import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Data
public class JSON2Obj {

    private static SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public <T> T parse(String objStr,Class<? extends T> tClass){
        return this.parse(objStr,tClass,smt);
    }

    public <T> List<T> parseArray(String jsonListStr, Class<? extends T> tClass){
        ObjectMapper mapper = new ObjectMapper();
        try{

            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, tClass);
            List<T> lst =  (List<T>)mapper.readValue(jsonListStr, javaType);
            return lst;
            //return mapper.readValue(jsonListStr, new TypeReference<List<T>>() {});
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public <T> T parse(String objStr, Class<? extends T> tClass, DateFormat format){
        try{
            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.setDateFormat(format);
            //mapper.setTimeZone(TimeZone.getTimeZone("GMT+9"));
//            mapper.setTimeZone(TimeZone.getTimeZone(timeZone));
            return mapper.readValue(objStr, tClass);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Date parseTime(String timeStr, String formatStr){
        if(StringUtils.isEmpty(timeStr)) return null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
//            format.setTimeZone(TimeZone.getTimeZone(timeZone));
            //format.setTimeZone(TimeZone.getTimeZone("GMT+9"));
            return format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Data
    private static class Entity implements Serializable {
        public Entity(Date date){ this.date = date;}
        public Entity( ){}
        //@JSONField(format="yyyy-MM-dd HH:mm:ss")
        @JSONField(format="yyyy-MM-dd")
        private Date date;
        public String toString(){
            return date.toString();
        }
    }

}

