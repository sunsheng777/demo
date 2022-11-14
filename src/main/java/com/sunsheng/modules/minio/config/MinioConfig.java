package com.sunsheng.modules.minio.config;


import com.sunsheng.modules.minio.entity.MinioEntity;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

	@Autowired
	private MinioEntity minioEntity;

	/**
	 * 创建minio连接
	 * @return
	 */
	@Bean
	public MinioClient minioClient(){
		return MinioClient.builder()
				.endpoint(minioEntity.getEndpoint())
				.credentials(minioEntity.getAccessKey(), minioEntity.getSecretKey())
				.build();
	}
}
