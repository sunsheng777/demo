package com.sunsheng.modules.rabbitmq;

//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;

//@Component
//@RequestMapping("/rabbitmq")
//public class RabbitMqDirects {
//    @Autowired
//    public RabbitTemplate rabbitTemplate;
    //    -------------------------路由模式-------------------------
//    @RequestMapping("/directs")
//    public void directs() {
//        //路由模式
//        rabbitTemplate.convertAndSend("testdirects", "info", "发送info的key的路由的信息");
//    }
//
//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,//创建临时队列
//                    exchange = @Exchange(value = "testdirects", type = "directs")//指定交换机和路由
//                    , key = {"info", "error", "warn"}
//            )
//    })
//    public void directs(String msg) {
//        System.out.println("路由模式------->" + msg);
//    }
//}
