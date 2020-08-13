package com.yky.ykyblog.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author: yky
 * @CreateTime: 2020-08-13
 * @Description: 重构Spring Security的PasswordEncoder
 */
public class MD5PasswordEncoder implements PasswordEncoder {
    //加密密码
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String) rawPassword);
    }

    //对比加密前后的密码是否相同
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Util.encode((String) rawPassword));
    }
}
