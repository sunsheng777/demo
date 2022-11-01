package com.sunsheng.project.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/test")
    @SendTo("/top/test")
    @ResponseBody
    public String call(String msg){
        System.out.println(msg);
        return msg;
    }

    @RequestMapping("/test01")
    @ResponseBody
    public String send() {
        System.out.println("发送成功");
        simpMessagingTemplate.convertAndSend("/top/test", "send.....");
        return "调用成功！";
    }

    @RequestMapping("/socketPage")
    public String socketPage(){
        return "socket";
    }

    @RequestMapping("/socket")
    public String socket() {
        return "modules/websocket/socket.html";
    }

    @SubscribeMapping("/top/test")
    public String test02(){
        String msg = " @SubscribeMapping";
        System.out.println(msg);
        return msg;
    }
}