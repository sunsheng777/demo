//package com.sunsheng.modules.activemq.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.sunsheng.common.utils.R;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
//@RequestM`apping("/active")
//@Controller
//public class ActiveMQController {
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @GetMapping("/add")
//    public R send() {
//        String s = UUID.randomUUID().toString().replace("-", "");
//        jmsMessagingTemplate.convertAndSend("msg",
//                JSONObject.toJSONString(s,
//                        SerializerFeature.PrettyFormat,
//                        SerializerFeature.WriteMapNullValue)
//        );
//        System.out.println("消息发送成功");
//        return R.ok().putData("list", s);
//    }
//
//    @JmsListener(destination = "msg")
//    public void getmsg(String s) {
//        System.out.println("消息接收成功" + s);
//    }
//}
