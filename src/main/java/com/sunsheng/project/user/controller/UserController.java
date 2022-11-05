package com.sunsheng.project.user.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.sunsheng.common.utils.R;
import com.sunsheng.project.user.entity.UserEntity;
import com.sunsheng.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/test")
    public R test() {
//        String url = "https://www.xxsypro.com/api/book/chapter/chapterList?cbid=22519934901664304";
//        String url = "https://www.xxsypro.com/api/book/auth/download/v2/chapters";
        SendPost sendPost = new SendPost();
        JSONObject jsonObject = sendPost.post1();
        System.out.println(jsonObject);
        return R.ok().putData("s", "s");
    }

    @ResponseBody
    @RequestMapping("/getTest")
    public R getAllUser(){
        List<UserEntity> userEntityList = userService.list();
        //实现excel读操作
        String filename = "D:\\下载\\write.xlsx";
        EasyExcel.write(filename, UserEntity.class).sheet(1).doWrite(userEntityList);
        return R.ok().putData("bookEntityList", userEntityList);
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public R getAll(){
        List<UserEntity> userEntityList = userService.getTestById(1);
        return R.ok().putData("bookEntityList", userEntityList);
    }
}
