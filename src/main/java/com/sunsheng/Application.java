package com.sunsheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//		(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.sunsheng.*"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("-------------------------启动成功-------------------------");
		System.out.println("http://localhost:8080/index/login");
	}
}
