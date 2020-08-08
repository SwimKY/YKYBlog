package com.yky.ykyblog.utils;

import java.security.MessageDigest;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: MD5加密工具
 */
public class MD5Util {

    private static final String SALT = "yky";

    /**
     * 自定义密码加密，然后使用MD5加密
     */
    public static String encode(String password) {
        password = SALT + password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
