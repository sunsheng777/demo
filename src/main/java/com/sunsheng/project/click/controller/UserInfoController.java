package com.sunsheng.project.click.controller;

import com.sunsheng.project.click.entity.UserInfo;
import com.sunsheng.project.click.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * https://www.jb51.net/article/237217.htm
 * @author: tonghp
 * @create: 2021/07/26 16:45
 */
@RestController
@RequestMapping("user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("saveData")
    public String saveData() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(4);
        userInfo.setUserName("winter");
        userInfo.setPassWord("567");
        userInfo.setPhone("13977776789");
        userInfo.setEmail("winter");
        userInfo.setCreateDay("2020-02-20");
        userInfoService.saveData(userInfo);
        return "sus";
    }

    @RequestMapping("selectById")
    public UserInfo selectById() {
        return userInfoService.selectById(1);
    }

    @RequestMapping("selectList")
    public List<UserInfo> selectList() {
        return userInfoService.selectList();
    }
}
