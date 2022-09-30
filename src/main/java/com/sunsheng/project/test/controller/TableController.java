package com.sunsheng.project.test.controller;

import com.sunsheng.common.utils.DateUtil;
import com.sunsheng.common.utils.R;
import com.sunsheng.project.test.entity.TableEntity;
import com.sunsheng.project.test.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author PC
 */
@Controller
@RequestMapping("/table")
public class TableController {
    @Resource
    private TableService tableService;

    @ResponseBody
    @RequestMapping("/gettest")
    public R gettest() {
        TableEntity entity = tableService.getByIdTest();
        System.out.println("--------");
        String tableName = entity.getTableName();
        System.out.println(tableName);
        System.out.println("--------");
        return R.ok().putData("s", "s");
    }

    @ResponseBody
    @RequestMapping("/gettest1")
    public R gettime() {
        DateUtil dateUtil = new DateUtil();
        Long date = dateUtil.getNowDateForLong();
        return R.ok().putData("time", date);
    }
}
