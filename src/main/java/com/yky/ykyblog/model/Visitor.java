package com.yky.ykyblog.model;

import lombok.Data;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 访客
 */
@Data
public class Visitor {

    private int id;

    /**
     * 访客人数
     */
    private long visitorNum;

    /**
     * 当前页的name or 文章名
     */
    private String pageName;
}
