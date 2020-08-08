package com.yky.ykyblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 标签
 */
@Data
@NoArgsConstructor
public class Tag {
    private int id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签大小
     */
    private int tagSize;

    public Tag(String tagName, int tagSize) {
        this.tagName = tagName;
        this.tagSize = tagSize;
    }

}
