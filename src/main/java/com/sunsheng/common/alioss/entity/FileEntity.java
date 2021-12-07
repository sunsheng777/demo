package com.sunsheng.common.alioss.entity;

import lombok.Data;

/**
 * 上传结果的返回值
 */
@Data
public class FileEntity {
    private String uid;//返回id
    private String absolutePath;//文件的绝对路径
    private String relativePath;//文件的相对路径
    private String status;//上传结果
    private String response;//返回值
}
