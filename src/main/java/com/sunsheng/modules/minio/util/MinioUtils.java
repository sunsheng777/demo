package com.sunsheng.modules.minio.util;


import com.alibaba.fastjson.JSON;
import com.sunsheng.modules.minio.entity.MinioEntity;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Component
public class MinioUtils {

	@Resource
	private MinioClient minioClient;
	@Resource
	private MinioEntity minioEntity;

	/**
	 * 检查存储桶是否存在
	 *
	 * @param bucketName 存储桶名称
	 * @return
	 */
	@SneakyThrows
	public boolean bucketExists(String bucketName) {
		BucketExistsArgs args = BucketExistsArgs.builder().bucket(bucketName).build();
		return minioClient.bucketExists(args);
	}

	/**
	 * 创建存储桶
	 *
	 * @param bucketName 存储桶名称
	 */
	@SneakyThrows
	public void makeBucket(String bucketName) {
		if (!bucketExists(bucketName)) {
			MakeBucketArgs args = MakeBucketArgs.builder().bucket(bucketName).build();
			minioClient.makeBucket(args);
		}
	}

	/**
	 * 获取全部bucket
	 */
	public List<Bucket> getAllBuckets() {
		try {
			List<Bucket> buckets = minioClient.listBuckets();
			return buckets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查看文件对象
	 * @return 存储bucket内文件对象信息
	 */
	public List<Item> listObjects() {
		Iterable<Result<Item>> results = minioClient.listObjects(
				ListObjectsArgs.builder().bucket(minioEntity.getBucketName()).build());
		List<Item> items = new ArrayList<>();
		try {
			for (Result<Item> result : results) {
				items.add(result.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return items;
	}

	/**
	 * 查询单个储桶中的所有对象。
	 *
	 * @param bucketName 存储桶名称
	 * @throws Exception
	 */
	public List<Object> listObjects(String bucketName) throws Exception {
		Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
		Iterator<Result<Item>> iterator = results.iterator();
		List<Object> items = new ArrayList<>();
		String format = "{'fileName':'%s','fileSize':'%s'}";
		while (iterator.hasNext()) {
			Item item = iterator.next().get();
			items.add(JSON.parse(String.format(format, item.objectName(),
					formatFileSize(item.size()))));
		}
		log.info("查询单个储桶中的所有对象信息：{}", items);
		return items;
	}


	/**
	 * 删除存储bucket
	 * @param bucketName 存储bucket名称
	 * @return Boolean
	 */
	public Boolean removeBucket(String bucketName) {
		try {
			minioClient.removeBucket(RemoveBucketArgs.builder()
					.bucket(bucketName)
					.build());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除一个对象
	 *
	 * @param bucketName 存储桶名称
	 * @param objectName 存储桶里的对象名称
	 */
	@SneakyThrows
	public boolean removeObject(String bucketName, String objectName) {
		if (bucketExists(bucketName)) {
			RemoveObjectArgs args = RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build();
			minioClient.removeObject(args);
			return true;
		}
		return false;
	}

	/**
	 * 批量删除文件对象
	 * @param bucketName 存储bucket名称
	 * @param objects 对象名称集合
	 */
	public Iterable<Result<DeleteError>> removeObjects(String bucketName, List<String> objects) {
		List<DeleteObject> dos = objects.stream().map(e -> new DeleteObject(e)).collect(Collectors.toList());
		Iterable<Result<DeleteError>> results = minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(dos).build());
		return results;
	}

	/**
	 * 批量上传文件
	 * @param multipartFile
	 * @return
	 */
	public List<String> putObject(MultipartFile[] multipartFile) {
		List<String> names = new ArrayList<>(multipartFile.length);
		for (MultipartFile file : multipartFile) {
			String fileName = file.getOriginalFilename();
			String[] split = fileName.split("\\.");
			if (split.length > 1) {
				fileName = split[0] + "_" + System.currentTimeMillis() + "." + split[1];
			} else {
				fileName = fileName + System.currentTimeMillis();
			}
			InputStream in = null;
			try {
				in = file.getInputStream();
				minioClient.putObject(PutObjectArgs.builder()
						.bucket(minioEntity.getBucketName())
						.object(fileName)
						.stream(in, in.available(), -1)
						.contentType(file.getContentType())
						.build()
				);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			names.add(fileName);
		}
		return names;
	}

	/**
	 * 单个文件上传
	 * @param file
	 * @param objectName
	 * @return
	 */
	public String putObject(MultipartFile file,String objectName) {
		// 获取文件服务器的地址和存储桶的名称
		String endpoint = minioEntity.getEndpoint();
		String bucketName = minioEntity.getBucketName();
		try {
			PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(minioEntity.getBucketName()).object(objectName)
					.stream(file.getInputStream(),file.getSize(),-1).contentType(file.getContentType()).build();
			//文件名称相同会覆盖
			minioClient.putObject(objectArgs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return endpoint+bucketName+"/"+objectName;
	}

	/**
	 * 获取文件地址
	 * @param fileName
	 * @return
	 */
	public String preview(String fileName){
		// 查看文件地址
		GetPresignedObjectUrlArgs build = GetPresignedObjectUrlArgs.builder()
				.bucket(minioEntity.getBucketName())
				.object(fileName).method(Method.GET)
				.build();
		try {
			return minioClient.getPresignedObjectUrl(build);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 文件批量下载
	 * @param fileName
	 * @return
	 */
	public ResponseEntity<byte[]> download(String fileName) {
		ResponseEntity<byte[]> responseEntity = null;
		InputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = minioClient.getObject(GetObjectArgs.builder().bucket(minioEntity.getBucketName()).object(fileName).build());
			out = new ByteArrayOutputStream();
			IOUtils.copy(in, out);
			//封装返回值
			byte[] bytes = out.toByteArray();
			HttpHeaders headers = new HttpHeaders();
			try {
				headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			headers.setContentLength(bytes.length);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setAccessControlExposeHeaders(Arrays.asList("*"));
			responseEntity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseEntity;
	}


	/**
	 * 单个文件下载
	 * @param fileName
	 * @param res
	 */
	public void download(String fileName, HttpServletResponse res) {
		GetObjectArgs objectArgs = GetObjectArgs.builder().bucket(minioEntity.getBucketName())
				.object(fileName).build();
		try (GetObjectResponse response = minioClient.getObject(objectArgs)){
			byte[] buf = new byte[1024];
			int len;
			try (FastByteArrayOutputStream os = new FastByteArrayOutputStream()){
				while ((len=response.read(buf))!=-1){
					os.write(buf,0,len);
				}
				os.flush();
				byte[] bytes = os.toByteArray();
				res.setCharacterEncoding("utf-8");
				// 设置强制下载不打开
				// res.setContentType("application/force-download");
				res.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
				try (ServletOutputStream stream = res.getOutputStream()){
					stream.write(bytes);
					stream.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String formatFileSize(long fileS) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		String wrongSize = "0B";
		if (fileS == 0) {
			return wrongSize;
		}
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + " B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + " KB";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + " MB";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + " GB";
		}
		return fileSizeString;
	}
}
