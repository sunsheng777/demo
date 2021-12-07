package com.sunsheng.modules.click;

import com.sunsheng.config.ClickHouseConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
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