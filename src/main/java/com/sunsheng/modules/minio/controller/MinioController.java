package com.sunsheng.modules.minio.controller;

import com.sunsheng.common.utils.R;
import com.sunsheng.modules.minio.entity.MinioEntity;
import com.sunsheng.modules.minio.controller.param.MinioParam;
import com.sunsheng.modules.minio.service.MinioService;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Resource
    private MinioService minioService;

    @Resource
    private MinioEntity minioEntity;

    /**
     * 获取所有得bucket
     *
     * @return
     */
    @GetMapping("/bucket/all")
    public R getAllBuckets() {
        System.out.println("进入了buckets=====");
        List<Bucket> s = minioService.getAllBuckets();
        return R.ok().put("s", s);
    }

    /**
     * 查看你文件列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<Object> list() {
        List<Object> items = minioService.listObjects(minioEntity.getBucketName());
        return items;
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R uploadFile(MultipartFile file) {
        minioService.upload(file);
        return R.ok();
    }

    /**
     * 删除文件
     *
     * @param param
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteFile(@RequestBody MinioParam param) {
        boolean status = minioService.delFile(minioEntity.getBucketName(), param.getFileName());
        return status ? R.ok() : R.fail(1, "");
    }

    /**
     * 单个文件下载
     *
     * @param param
     * @param res
     * @return
     */
    @PostMapping("/download")
    public R download(@RequestBody MinioParam param, HttpServletResponse res) {
        minioService.download(param.getFileName(), res);
        return R.ok();
    }

    /**
     * 预览照片
     *
     * @param param
     * @return
     */
    @GetMapping("/preview")
    public R preview(@RequestBody MinioParam param) {
        minioService.preview(param.getFileName());
        return R.ok();
    }

}
