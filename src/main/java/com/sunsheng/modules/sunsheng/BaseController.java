package com.sunsheng.modules.sunsheng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/index")
public class BaseController {
    @RequestMapping("/login")
    public String index() {
        return "modules/sunsheng/index.html";
    }
    @RequestMapping("/fwb")
    public String fwb() {
        return "modules/sunsheng/fwb.html";
    }
}
