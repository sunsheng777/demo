package com.sunsheng.project.test.controller;

import com.sunsheng.common.utils.DateUtil;
import com.sunsheng.common.utils.R;
import com.sunsheng.project.test.entity.AllTableEntity;
import com.sunsheng.project.test.entity.TableEntity;
import com.sunsheng.project.test.service.AllTableService;
import com.sunsheng.project.test.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author PC
 */
@RestController
@RequestMapping("/allTable")
public class AllTableController {
    @Resource
    private AllTableService allTableService;

//    @ResponseBody
    @GetMapping("/gettest")
    public R gettest() {
        AllTableEntity entity1 = allTableService.getByTableName();
//        AllTableEntity entity1 = allTableService.getById(1);
        System.out.println("===============");
        System.out.println(entity1);
        System.out.println("===============");
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
