package com.yky.ykyblog.service;


import com.yky.ykyblog.utils.DataMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:标签业务操作
 */
public interface TagService {

    /**
     * 加入标签
     *
     * @param tags    一群标签
     * @param tagSize 标签大小
     */
    void addTags(String[] tags, int tagSize);

    /**
     * 获得标签云
     *
     * @return
     */
    DataMap findTagsCloud();

    /**
     * 获得标签云数量
     *
     * @return
     */
    int countTagsNum();

    /**
     * 通过标签名获得标签大小
     *
     * @param tagName
     * @return
     */
    int getTagsSizeByTagName(String tagName);
}
