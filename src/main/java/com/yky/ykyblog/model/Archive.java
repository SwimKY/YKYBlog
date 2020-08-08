package com.yky.ykyblog.model;

import lombok.Data;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 文章归档
 */
@Data
public class Archive {

    private int id;
    /**
     * 归档日期
     */
    private String archiveName;

}
