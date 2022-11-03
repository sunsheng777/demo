package com.sunsheng.modules.clickt.controller;

import com.sunsheng.common.utils.DateUtil;
import com.sunsheng.common.utils.R;
import com.sunsheng.config.ClickHouseConfig;
import com.sunsheng.modules.clickt.entity.ClickEntity;
import com.sunsheng.modules.clickt.service.ClickService;
import com.sunsheng.project.test.dao.TableMapper;
import com.sunsheng.project.test.entity.AllTableEntity;
import com.sunsheng.project.test.entity.TableEntity;
import com.sunsheng.project.test.service.AllTableService;
import com.sunsheng.project.test.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author PC
 */
@RestController
@RequestMapping("/click")
public class ClickController {
    @Resource
    public ClickService clickService;

    @ResponseBody
    @RequestMapping("/gettest")
    public R gettest() {
//        Integer id = 1;
//        ClickEntity click = clickService.getTestById(id);

//        String sql = "select * from user where id = 1";
//        ClickEntity click = (ClickEntity) ClickHouseConfig.exeSql(sql);

        ClickEntity click = new ClickEntity();
        click.setName(UUID.randomUUID().toString().replace("-",""));
        click.setAge(12);
        clickService.saveData(click);
        return R.ok().putData("clickEntity", click);
    }


    @RequestMapping(value = "/addAll")
    public R exeSql() {
        String sql = "select * from user";
        List<Map<String, String>> result = ClickHouseConfig.exeSql(sql);
        System.out.println(result);
        return R.ok().putData("result", result);
    }
}
