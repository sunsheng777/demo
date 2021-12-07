package com.sunsheng.common.alioss.controller;//package com.sunsheng.common.alioss.controller;
//
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.common.utils.BinaryUtil;
//import com.aliyun.oss.model.MatchMode;
//import com.aliyun.oss.model.PolicyConditions;
//import com.sunsheng.common.alioss.config.AliyunConfig;
//import com.sunsheng.common.alioss.service.FileUploadService;
//import com.sunsheng.common.utils.DateUtil;
//import com.sunsheng.common.utils.LoggerUtil;
//import com.sunsheng.common.utils.R;
//import com.sunsheng.common.utils.SanYuanUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RequestMapping("/common/upload/sts")
//@Controller
//@RestController
//public class FileUploadController {
//
//    private LoggerUtil loggerUtil = new LoggerUtil();
//    @Autowired
//    private FileUploadService fileUploadService;
//    @Autowired
//    private AliyunConfig aliyunConfig;
//
//    private SanYuanUtil sanYuanUtil = new SanYuanUtil();
//
//    DateUtil dateUtil = new DateUtil();
//
//    @GetMapping("/getOss")
//    public R getOss(@RequestParam Map<String,Object> params){
//
//        String type =  sanYuanUtil.sytoString(params.get("type"));
//
//        String path = "";
//        if("1".equals(type)){
//            //上传公司图片
//            path = "company/";
//        }else if("2".equals(type)){
//            //上传专柜图片
//            path = "counter/";
//        }else {
//            path="web/";
//        }
//
//        String accessId = aliyunConfig.getAccessKeyId(); // 请填写您的AccessKeyId。
//        String accessKey = aliyunConfig.getAccessKeySecret(); // 请填写您的AccessKeySecret。
//        String endpoint = aliyunConfig.getEndpoint(); // 请填写您的 endpoint。
//        String bucket = aliyunConfig.getBucketName(); // 请填写您的 bucketname 。
//        String host = "http://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
//        // callbackUrl为 上传回调服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
////        String callbackUrl = "http://88.88.88.88.:8888";
////        String dir = "Uploads/files/web/20191213"+ dateUtil.getCurrentMonth(); // 用户上传文件时指定的前缀。
//        String dir = aliyunConfig.getUrlPrefix() + path + dateUtil.getNowDateDay(); // 用户上传文件时指定的前缀。
//        OSSClient client = new OSSClient(endpoint, accessId, accessKey);
//        try {
//            if(!client.doesBucketExist(bucket)){
//                client.createBucket(bucket);
//            }
//            long expireTime = 30;
//            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
//            Date expiration = new Date(expireEndTime);
//            loggerUtil.getLogger().debug("当前时间：" + expiration );
//            PolicyConditions policyConds = new PolicyConditions();
//            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
//            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
//
//            String postPolicy = client.generatePostPolicy(expiration, policyConds);
//            byte[] binaryData = postPolicy.getBytes("utf-8");
//            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
//            String postSignature = client.calculatePostSignature(postPolicy);
//
//            Map<String, String> respMap = new LinkedHashMap<>();
//            respMap.put("accessid", accessId);
//            respMap.put("policy", encodedPolicy);
//            respMap.put("signature", postSignature);
//            respMap.put("dir", dir);
//            respMap.put("host", host);
//            respMap.put("expire", String.valueOf(expireEndTime / 1000));
////            return R.ok().putData(respMap);
//
////             respMap.put("expire", formatISO8601Date(expiration));
//
////            JSONObject jasonCallback = new JSONObject();
////            jasonCallback.put("callbackUrl", aliyunConfig.getCallbackUrl());
////            jasonCallback.put("callbackBody",
////                    "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
////            jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
////            String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
////            respMap.put("callback", base64CallbackBody);
//
////            JSONObject ja1 = JSONObject.fromObject(respMap);
//            // System.out.println(ja1.toString());
////            response.setHeader("Access-Control-Allow-Origin", "*");
////            response.setHeader("Access-Control-Allow-Methods", "GET, POST");
////            response(request, response, JSON.toJSONString(respMap));
//            return R.ok().putData(respMap);
//        } catch (Exception e) {
//            // Assert.fail(e.getMessage());
//            loggerUtil.getLogger().debug("get oss enter error" );
//        }
//
////        return R.fail();
//        return null;
//    }
////    @PostMapping
////    @ResponseBody
////    @RequestMapping("/testimgone")
////    public FileEntity upload(@RequestParam("file")MultipartFile multipartFile){
////        FileEntity s = fileUploadService.uploadImg(multipartFile);
////        return s;
////    }
//
//    /**
//     * 多文件上传
//     */
////    @PostMapping
////    @ResponseBody
////    @RequestMapping("/testimgtwo")
////    public R upload(@RequestParam("file") MultipartFile[] files) throws IOException {
////        FileEntity fileEntity;
////        R r = new R();
////        if (files.length != 0) {
////            for (MultipartFile file : files) {
////                fileEntity = fileUploadService.uploadImg(file);
////                r.put(fileEntity.getUid(),fileEntity);
////            }
////        } else if (files.length==0){
////            r.put("success",0);
////        }
////        return r;
////    }
////    @PostMapping
////    @ResponseBody
////    @RequestMapping("/creatDir")
////    public boolean creatDir(){
////        boolean b = fileUploadService.creatDir();
////        return b;
////    }
//}
