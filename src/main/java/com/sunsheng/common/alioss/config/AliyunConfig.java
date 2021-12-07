package com.sunsheng.common.alioss.config;//package com.sunsheng.common.alioss.config;
//
//import com.aliyun.oss.OSSClient;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * 阿里云上传设置类
// * 读取properties配置的上传路径
// */
//@Configuration
//@PropertySource(value = "classpath:aliyun.properties")
//@ConfigurationProperties(prefix = "aliyun")
//@Data
//public class AliyunConfig {
//    private String endpoint;//获取云服务器地址
//    private String accessKeyId;//获取账户key
//    private String accessKeySecret;//获取账户的密码
//    private String bucketName;//获取账户的目录
//    private String urlPrefix;//获取返回地址的前部分
//
//
//    private String callbackUrl;//文件上传回调地址
//    @Bean
//    public OSSClient ossClient(){
//        return new OSSClient(endpoint,accessKeyId,accessKeySecret);
//    }
//}
