package com.sunsheng.modules.minio.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * minio配置类
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioEntity {

	/**服务器所在地址**/
	private String endpoint;

	/**存储桶的名称**/
	private String bucketName;

	/**访问的key**/
	private String accessKey;

	/**访问的密钥**/
	private String secretKey;


}
