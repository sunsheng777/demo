package com.sunsheng.modules.minio.service;

import io.minio.messages.Bucket;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MinioService {

	/**
	 * 获取全部的桶
	 * @return
	 */
	List<Bucket> getAllBuckets();

	/**
	 * 判断 bucket是否存在
	 *
	 * @param bucketName
	 * @return
	 */
	Boolean bucketExists(String bucketName);

	/**
	 * 创建 bucket
	 *
	 * @param bucketName
	 */
	void makeBucket(String bucketName);

	/**
	 * 查询单个储桶中的所有对象
	 * @param bucketName
	 * @return
	 */
	List<Object> listObjects(String bucketName);

	/**
	 * 文件上传
	 * @return
	 */
	String upload(MultipartFile multipartFile);

	/**
	 * 删除文件
	 */
	Boolean delFile(String bucketName,String fileName);

	/**
	 * 获取文件链接
	 */
	String preview(String fileName);

	/**
	 * 文件下载
	 * @return
	 */
	void download(String fileName, HttpServletResponse res);
}
