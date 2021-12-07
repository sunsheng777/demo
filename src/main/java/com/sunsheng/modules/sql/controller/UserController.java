package com.sunsheng.modules.sql.controller;

import com.alibaba.excel.EasyExcel;
import com.sunsheng.common.utils.DateUtil;
import com.sunsheng.common.utils.R;
import com.sunsheng.modules.sql.entity.UserEntity;
import com.sunsheng.modules.sql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/test/gettime")
    public R gettime() {
        DateUtil dateUtil = new DateUtil();
        Long date = dateUtil.getNowDateForLong();
        return R.ok().putData("time", date);
    }

    @ResponseBody
    @RequestMapping("/test/gettime1")
    public R gettime1() {
        DateUtil dateUtil = new DateUtil();
        Long date = dateUtil.getNowDateForLong();
        return R.ok().putData(date);
    }

    @ResponseBody
    @RequestMapping("/test/gettime2")
    public R gettime2() {
        DateUtil dateUtil = new DateUtil();
        Long date = dateUtil.getNowDateForLong();
        Map<String, Object> res = new HashMap<>();
        res.put("time", date);
        return R.ok().putData(res);
    }
    @ResponseBody
    @RequestMapping("/getAllUser")
    public R getAllUser(@RequestParam Map<String, Object> params){
        List<UserEntity> userEntity = userService.list();
        //实现excel读操作
        String filename = "D:\\下载\\write.xlsx";
        EasyExcel.write(filename,UserEntity.class).sheet(1).doWrite(userEntity);
        return R.ok().putData("time",userEntity);
    }

    @ResponseBody
    @RequestMapping("/addNumUser")
    public R addNumUser(Integer num){
        List<UserEntity> list = new LinkedList<>();
        UserEntity userEntity;
        for (int i = 0; i < num; i++) {
            userEntity = new UserEntity();
            userEntity.setId(i+"");
            userEntity.setName("username" + i);
            list.add(userEntity);
        }
        userService.saveBatch(list);
        return R.ok().putData("userList",list);
    }

    @ResponseBody
    @RequestMapping("/getTest")
    public R getTest(){
        List<UserEntity> list = userService.getTest();
        return R.ok().put("list",list);
    }
}
