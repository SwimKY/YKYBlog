package com.yky.ykyblog.controller;


import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.redis.RedisService;
import com.yky.ykyblog.service.SmsService;
import com.yky.ykyblog.utils.AliUtils;
import com.yky.ykyblog.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe: 注册获得手机验证码
 */
@RestController
@Slf4j
public class GetPhoneCodeControl {

    @Autowired
    private SmsService smsService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String REGISTER = "register";

    @PostMapping(value = "/getCode")//produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    public String getAuthCode(@RequestParam("phone") String phone,
                              @RequestParam("sign") String sign) {

        if (StringUtils.isEmpty(phone)) {
            return JsonResult.fail(CodeType.AUTH_CODE_EXIST).toJSON();
        }
        String code = (String) redisTemplate.opsForValue().get(phone);
        if(code != null && !StringUtils.isEmpty(code)){
            return JsonResult.fail(CodeType.PHONE_NULL_ERROR).toJSON();
        }
        String msgCode;
        //采用不同的短信模板
        if (REGISTER.equals(sign)) {//使用表示注册的验证码
            msgCode = AliUtils.ALIBABA_SMSCODEONE;
        } else {
            msgCode = AliUtils.ALIBABA_SMSCODEONE;
        }
        //发送短信
        boolean isSendSms = smsService.sendSms(phone, msgCode);
        if (isSendSms) {
            return JsonResult.success().toJSON();
        } else {
            return JsonResult.fail().toJSON();
        }
    }

}
