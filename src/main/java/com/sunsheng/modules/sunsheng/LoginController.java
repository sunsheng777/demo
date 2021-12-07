package com.sunsheng.modules.sunsheng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;


@Controller
@RequestMapping("/admin")
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "modules/login/login.html";
    }
    @RequestMapping("/login1")
    public String login1() {
        Object obj = new Object();//创建强引用对象
        //创建弱引用对象，并将强引用放入弱引用，当内存不足时，立即回收弱引用
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        obj = null;//销毁强引用
        //弱引用HashMap
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put("a","a");
        return "modules/login/login1.html";
    }
}
