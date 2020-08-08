package com.yky.ykyblog.controller;

import com.yky.ykyblog.constant.CodeType;
import com.yky.ykyblog.model.User;
import com.yky.ykyblog.redis.StringRedisServiceImpl;
import com.yky.ykyblog.service.UserService;
import com.yky.ykyblog.utils.JsonResult;
import com.yky.ykyblog.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe: 登录控制
 */
@RestController
@Slf4j
public class LoginControl {

    @Autowired
    UserService userService;
    @Autowired
    StringRedisServiceImpl stringRedisService;

    @PostMapping(value = "/changePassword", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String changePassword(@RequestParam("phone") String phone,
                                 @RequestParam("authCode") String authCode,
                                 @RequestParam("newPassword") String newPassword){

        try {
            String trueMsgCode = (String) stringRedisService.get(phone);

            //判断获得的手机号是否是发送验证码的手机号
            if(trueMsgCode == null){
                return JsonResult.fail(CodeType.PHONE_ERROR).toJSON();
            }
            //判断验证码是否正确
            if(!authCode.equals(trueMsgCode)){
                return JsonResult.fail(CodeType.AUTH_CODE_ERROR).toJSON();
            }
            User user = userService.findUserByPhone(phone);
            if(user == null){
                return JsonResult.fail(CodeType.USERNAME_NOT_EXIST).toJSON();
            }
            String mD5Password = MD5Util.encode(newPassword);
            userService.updatePasswordByPhone(phone, mD5Password);

            //修改密码成功删除redis中的验证码
            stringRedisService.remove(phone);

            return JsonResult.success().toJSON();
        } catch (Exception e){
            log.error("[{}] change password [{}] exception", phone, newPassword, e);
        }
        return JsonResult.fail(CodeType.SERVER_EXCEPTION).toJSON();
    }

}
