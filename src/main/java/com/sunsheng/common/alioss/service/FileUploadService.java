package com.sunsheng.common.alioss.service;//package com.sunsheng.common.alioss.service;
//
//import com.aliyun.oss.OSSClient;
//import com.sunsheng.common.alioss.config.AliyunConfig;
//import com.sunsheng.common.alioss.entity.FileEntity;
//import com.sunsheng.common.utils.DateUtil;
//import com.sunsheng.common.utils.R;
//import com.sunsheng.common.utils.UUIDUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//
///**
// * 文件上传业务类
// */
//@Service
//public class FileUploadService {
////    private static final String [] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};
//    @Autowired
//    private OSSClient ossClient;
//    @Autowired
//    private AliyunConfig aliyunConfig;
//    @Autowired
//    private DateUtil dateUtil;
//    UUIDUtil uuidUtil = new UUIDUtil();
////    public FileEntity uploadImg(MultipartFile uploadFile){
////        FileEntity fileEntity = new FileEntity();
////        String filetypename = uploadFile.getOriginalFilename();//获取文件名
////        String tmpfilename = "";
////        if (!filetypename.isEmpty()){//如果文件名存在不为空
////            tmpfilename = filetypename.substring(filetypename.indexOf("."),filetypename.length());
////        }
////        String filePath = "zgtest/zg/"+uuidUtil.getUUID()+tmpfilename;//将文件名变成uuid
////        try {
////            ossClient.putObject(aliyunConfig.getBucketName(),filePath,new ByteArrayInputStream(uploadFile.getBytes()));
////        }catch (Exception e){
////            e.printStackTrace();
////            fileEntity.setStatus("error");
////            return fileEntity;
////        }
////        fileEntity.setStatus("done");//设置上传结果
////        fileEntity.setAbsolutePath(this.aliyunConfig.getUrlPrefix()+filePath);//设置上传结果的路径
////        fileEntity.setRelativePath(filePath);
////        fileEntity.setUid(String.valueOf(System.currentTimeMillis()));//当前时间的毫秒值
////        return fileEntity;
////    }
//
//    /**
//     * 创建修改公司的文件上传类
//     * @param path
//     * @param uploadFile
//     * @return
//     */
//    public FileEntity uploadImg(String path,MultipartFile uploadFile){
//        FileEntity fileEntity = new FileEntity();
//        String filetypename = uploadFile.getOriginalFilename();//获取文件名
//        String filetype = "";
//        String filename = "";
//        //获取文件的属性类型
//        if (!filetypename.isEmpty()){//如果文件名存在不为空
//            filetype = filetypename.substring(filetypename.indexOf("."),filetypename.length());
//            filename = filetypename.substring(0,filetypename.indexOf("."));
//        }
//        String filePath = "zgtest/"+path+"/"+filename+dateUtil.getNowDateForLong()+filetype;//将文件名变成毫秒值
//        try {
//            ossClient.putObject(aliyunConfig.getBucketName(),filePath,new ByteArrayInputStream(uploadFile.getBytes()));
//        }catch (Exception e){
//            e.printStackTrace();
//            fileEntity.setStatus("error");
//            return fileEntity;
//        }
//        fileEntity.setStatus("done");//设置上传结果
//        fileEntity.setAbsolutePath(this.aliyunConfig.getUrlPrefix()+filePath);//设置上传结果的路径
//        fileEntity.setRelativePath(filePath);
//        fileEntity.setUid(String.valueOf(System.currentTimeMillis()));//当前时间的毫秒值
//        return fileEntity;
//    }
//
//
//    /**
//     * 获取图片上传配置
//     * @return
//     */
//    public R getStsOss(){
//
//        return R.ok();
//    }
//}
