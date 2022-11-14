package com.sunsheng.modules.minio.service.impl;


import com.sunsheng.modules.minio.service.MinioService;
import com.sunsheng.modules.minio.util.MinioUtils;
import io.minio.messages.Bucket;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class MinioServiceImpl implements MinioService {

	@Resource
	private MinioUtils minioUtils;

	@Override
	public List<Bucket> getAllBuckets() {
		return minioUtils.getAllBuckets();
	}

	@Override
	public Boolean bucketExists(String bucketName) {
		return minioUtils.bucketExists(bucketName);
	}

	@Override
	public void makeBucket(String bucketName) {
		minioUtils.makeBucket(bucketName);
	}

	@SneakyThrows
	@Override
	public List<Object> listObjects(String bucketName) {
		return minioUtils.listObjects(bucketName);
	}

	@Override
	public String upload(MultipartFile multipartFile) {
		String fileName = multipartFile.getOriginalFilename();
		// 根据需要，设置文件在存储目录，先采用时间为文件夹
		String path = new SimpleDateFormat("yyyy-MM-dd/").format(new Date());
		log.info("文件保存路径为:{}",path);
		String objectName = path + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		return minioUtils.putObject(multipartFile,objectName);
	}


	@Override
	public Boolean delFile(String bucketName,String fileName) {
		return minioUtils.removeObject(bucketName, fileName);
	}

	@Override
	public String preview(String fileName) {
		return minioUtils.preview(fileName);
	}


	@Override
	public void download(String fileName, HttpServletResponse res) {
		minioUtils.download(fileName,res);
	}
}
