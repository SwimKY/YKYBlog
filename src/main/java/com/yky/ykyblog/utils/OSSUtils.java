package com.yky.ykyblog.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: OSS相关常量配置
 */
@Component
public class OSSUtils implements InitializingBean {
    /**
     * 男生默认头像
     */
    public static final String MALE_IMAGE = "http://ykyblog.oss-cn-shenzhen.aliyuncs.com/userImage/famel.jpg";
    /**
     * 女生默认头像
     */
    public static final String FEMALE_IMAGE = "http://ykyblog.oss-cn-shenzhen.aliyuncs.com/userImage/male.jpg";

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.CarouselBucketName}")
    private String CarouselBucketName;

    public static String OSS_ENDPOINT;
    public static String OSS_BUCKETNAME;
    public static String Oss_CAROUSEL_BUCKETNAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        OSS_ENDPOINT = endpoint;
        OSS_BUCKETNAME = bucketName;
        Oss_CAROUSEL_BUCKETNAME = CarouselBucketName;
    }

}
