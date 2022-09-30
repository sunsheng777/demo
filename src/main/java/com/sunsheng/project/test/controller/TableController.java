package com.sunsheng.project.test.controller;

import com.sunsheng.common.utils.DateUtil;
import com.sunsheng.common.utils.R;
import com.sunsheng.project.test.entity.AllTableEntity;
import com.sunsheng.project.test.entity.TableEntity;
import com.sunsheng.project.test.service.AllTableService;
import com.sunsheng.project.test.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author PC
 */
@Controller
@RequestMapping("/table")
public class TableController {
    @Resource
    private TableService tableService;

    @Resource
    private AllTableService allTableService;

    @ResponseBody
    @RequestMapping("/gettest")
    public R gettest() {
        List<TableEntity> entity = tableService.getByIdTest();
        System.out.println("--------");
        for (TableEntity e : entity) {
            String tableName = e.getTableName();
            System.out.println(tableName);
            List<AllTableEntity> tableEntities = allTableService.getByTableName(tableName);
            for (AllTableEntity a : tableEntities) {
                System.out.println(a);
            }
        }
        System.out.println("--------");
        return R.ok().putData("s", entity);
    }

    @ResponseBody
    @RequestMapping("/gettest1")
    public R gettime() {
        DateUtil dateUtil = new DateUtil();
        Long date = dateUtil.getNowDateForLong();
        return R.ok().putData("time", date);
    }
}
