package com.yky.ykyblog.service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yky.ykyblog.utils.AliUtils;
import com.yky.ykyblog.utils.JsonResult;
import com.yky.ykyblog.utils.RandomUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 发送验证码
 */
@Service
public class SmsService{

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 发送手机验证码
     *
     * @param phone
     * @param msgCode 短信模板
     * @return
     */
    public  boolean sendSms(String phone,String msgCode) {
        if(StringUtils.isEmpty(phone)||StringUtils.isEmpty(msgCode))return false;
        //获取验证码
        String code = RandomUtil.getSixBitRandom();
        //自定义的code值传参需要是json数据，使用fastjson =》map集合转成json数据格式
        Map<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", code);
        //创建对象
        DefaultProfile profile =
                DefaultProfile.getProfile("cn-hangzhou", AliUtils.ALIBABA_KEYID, AliUtils.ALIBABA_KEYSECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        //配置参数
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //配置其他参数
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", AliUtils.ALIBABA_SMS_NAME);//短信签名
        request.putQueryParameter("TemplateCode", msgCode);//短信模板
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(codeMap));//传入json格式的数据
        try {
            //发送
            CommonResponse response = client.getCommonResponse(request);
            //发送后把验证码存入redis，用于验证
            redisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            //获取状态码
            int status = response.getHttpResponse().getStatus();
            if (status == 200) return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
