package com.yky.ykyblog.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: 爱敲代码的小游子
 * @CreateTime: 2020-07-27-09
 * 启动后执行该方法
 */
@Component
public class AliUtils implements InitializingBean {

    @Value("${aliyun.msm.keyid}")
    private String keyid;
    @Value("${aliyun.msm.keysecret}")
    private String keysecret;
    @Value("${aliyun.msm.smscode.one}")
    private String smscodeOne;


    public static String ALIBABA_KEYID;
    public static String ALIBABA_KEYSECRET;
    public static String ALIBABA_SMSCODEONE;//短信模板
    public static String ALIBABA_SMS_NAME;//短信签名

    @Override
    public void afterPropertiesSet() throws Exception {
        ALIBABA_KEYID = keyid;
        ALIBABA_KEYSECRET = keysecret;
        ALIBABA_SMSCODEONE = smscodeOne;
        ALIBABA_SMS_NAME="爱敲代码的小游子";
    }
}
