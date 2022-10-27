package com.sunsheng.project.rabbitmq;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rabbitmq")
public class ProductionAndConsume {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping("/test")
    public void test() {
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend("exchange_test", "key", "测试消息");
    }

    //监听email队列
    @RabbitListener(queues = "exchange_test")
    public void testq(Object msg) {
        System.out.println("exchange_test------->" + msg);
    }
}