package com.yky.ykyblog.service;

import com.yky.ykyblog.utils.DataMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:悄悄话业务操作
 */
public interface PrivateWordService {

    /**
     * 发布悄悄话
     * @param privateWordContent 悄悄话
     * @return
     */
    @Transactional
    DataMap publishPrivateWord(String privateWordContent, String username);

    /**
     * 获得悄悄话内容
     * @param publisher
     * @return
     */
    DataMap getPrivateWordByPublisher(String publisher, int rows, int pageNum);

    /**
     * 获得所有悄悄内容
     * @return
     */
    DataMap getAllPrivateWord();

    /**
     * 回复悄悄话
     * @param replyContent 回复内容
     * @param username 回复人
     * @return
     */
    @Transactional
    DataMap replyPrivateWord(String replyContent, String username, int id);
}
