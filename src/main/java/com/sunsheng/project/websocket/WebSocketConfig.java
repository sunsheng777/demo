package com.sunsheng.project.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 设置socket连接
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        System.out.println("----test----");
        stompEndpointRegistry.addEndpoint("/testSocket")
                .setAllowedOrigins("*") //解决跨域问题
                .withSockJS();
    }

    // 设置发布订阅的主题
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic", "/top");
    }
}