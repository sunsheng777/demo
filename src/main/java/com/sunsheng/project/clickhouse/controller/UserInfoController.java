package com.sunsheng.project.clickhouse.controller;

import com.sunsheng.project.clickhouse.entity.UserInfo;
import com.sunsheng.project.clickhouse.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/clickhouse")
public class UserInfoController {

//    @Resource
//    private UserInfoService userInfoService;

    //localhost:7010/saveData
//    @GetMapping("/saveData")
//    public String saveData() {
//        for (int i = 0; i < 10; i++) {
//            UserInfo userInfo = new UserInfo();
//            userInfo.setId(i);
//            userInfo.setUserName("xiaolin" + i);
//            userInfo.setPassWord("paw" + i);
//            userInfo.setPhone("1111" + i);
//            userInfo.setCreateDay("2022-02-06");
//            userInfoService.saveData(userInfo);
//        }
//        return "success";
//    }
//
//    //localhost:7010/getById?id=1
//    @GetMapping("/getById")
//    public UserInfo getById(int id) {
//        return userInfoService.selectById(id);
//    }
//
//    @GetMapping("/getList")
//    public List<UserInfo> getList() {
//        return userInfoService.selectList();
//    }

}
