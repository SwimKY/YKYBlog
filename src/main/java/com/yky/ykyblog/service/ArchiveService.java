package com.yky.ykyblog.service;

import com.yky.ykyblog.utils.DataMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe: 归档业务操作
 */
public interface ArchiveService {

    /**
     * 获得归档信息
     *
     * @return
     */
    DataMap findArchiveNameAndArticleNum();

    /**
     * 添加归档日期
     *
     * @param archiveName
     */
    void addArchiveName(String archiveName);

}
