package com.sunsheng.modules.rabbitmq;


import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Component
@Controller
@RequestMapping("/rabbitmq")
public class ProductionAndConsume {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping("/send")
    public void send() {
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend("suntest", "测试消息");
    }

    //消费者
    @RabbitListener(queuesToDeclare = @Queue("suntest"))
    @RabbitHandler
    public void testq(String msg) {
        System.out.println("suntest------->" + msg);
    }

//    -------------------------一对多发送接收消息-------------------------

    @ResponseBody
    @RequestMapping("/send2")
    public void send2() {
        /**
         * 参数：
         * 1、交换机名称
         * 2、routingKey
         * 3、消息内容
         */
        rabbitTemplate.convertAndSend("logs", "", "测试群发消息");
    }

    //消费者
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs", type = "fanout")//绑定交换机
            )
    })
    public void suntest1(String msg) {
        System.out.println("suntest1------->" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs", type = "fanout")//绑定交换机
            )
    })
    public void suntest2(String msg) {
        System.out.println("suntest2------->" + msg);
    }
//    -------------------------路由模式-------------------------

    @ResponseBody
    @RequestMapping("/send3")
    public void send3() {
        //路由模式
        rabbitTemplate.convertAndSend("directs", "info", "发送info的key的路由的信息");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs", type = "directs"),//指定交换机和路由
                    key = {"info","error","warn"}
            )}
    )
    @RabbitHandler
    public void directs(String msg) {
        System.out.println("路由模式------->" + msg);
    }

    //    -------------------------动态路由，订阅模式-------------------------

    @ResponseBody
    @RequestMapping("/testTopic")
    public void testTopic() {
        //路由模式
        rabbitTemplate.convertAndSend("topic", "user.save", "动态路由");
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(type = "topic",name = "topics"),//指定交换机和路由
                    key = {"user.save","user.*"}
            )}
    )
    @RabbitHandler
    public void testTopics(String msg) {
        System.out.println("路由模式------->" + msg);
    }
}
