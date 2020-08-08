package com.yky.ykyblog.utils;

import com.yky.ykyblog.model.Result;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 统一返回格式
 */
public class ResultUtil {
    public static Result success(String msg) {
        return success(200, msg);
    }

    public static Result success(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result success(Integer code, Object object, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setData(object);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
