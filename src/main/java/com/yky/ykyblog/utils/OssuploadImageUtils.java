package com.yky.ykyblog.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

/**
 * @Author: 爱敲代码的小游子
 * @CreateTime: 2020-08-02-18
 */
public class OssuploadImageUtils {

    private static String endpoint = OSSUtils.OSS_ENDPOINT; // OSS外放访问节点
    private static String accessKeyId = AliUtils.ALIBABA_KEYID;
    private static String accessKeySecret = AliUtils.ALIBABA_KEYSECRET;

    /**
     * 获得阿里云OSS客户端对象
     * @return ossClient
     */
    public static OSS getOSSClient(){
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 上传图片
     */
    public static Map<String, Object> uploadImage(MultipartFile file, String bucketName){
        HashMap<String, Object> ossMap = new HashMap<>();
        String uploadUrl = "";
        try {
            OSS ossClient = getOSSClient();
            //防止出现相同文件被覆盖
            //文件名：uuid.扩展名
            String fileName = file.getOriginalFilename();
            //1、防止文件名相同覆盖之前的文件-->使用uuid拼接fileName
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;
            //2、把文件按日期分类管理
            String time = new DateTime().toString("yyyy/MM/dd");
            fileName = time + "/" + fileName;
            // 上传文件流
            InputStream inputStream = file.getInputStream();
            ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //获取url地址
            uploadUrl = "http://" + bucketName + "." + endpoint + "/" + fileName;
            ossMap.put("fileName",fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ossMap.put("uploadUrl",uploadUrl);
        return ossMap;
    }

    /**
     * 删除oss文件
     */
    public static boolean deleteImageOss(String fileName,String bucketName){
        // 创建OSSClient实例。
        OSS ossClient = getOSSClient();
        // 删除文件。key等同于ObjectName，表示删除OSS文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        List<String> keys = new ArrayList<>();
        keys.add(fileName);
        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys));
        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        // 关闭OSSClient。
        ossClient.shutdown();
        if(deletedObjects.size()>0){ return true; } else { return false; }
    }

}
