package com.sunsheng.project.book.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunsheng.common.utils.R;
import com.sunsheng.project.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author PC
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

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
}
