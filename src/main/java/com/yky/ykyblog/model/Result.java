package com.yky.ykyblog.model;

import lombok.Data;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 统一返回结果
 */
@Data
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
