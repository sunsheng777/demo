package com.sunsheng.modules.clickt;

import com.sunsheng.config.ClickHouseConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/click")
public class ClickHouseConfigTest {


    @RequestMapping(value = "/addAll")
    public void exeSql() {
        String sql="select * from clusters";
        List<Map<String,String>> result= ClickHouseConfig.exeSql(sql);
        System.out.println(result);
    }
}