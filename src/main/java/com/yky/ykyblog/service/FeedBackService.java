package com.yky.ykyblog.service;


import com.yky.ykyblog.model.FeedBack;
import com.yky.ykyblog.utils.DataMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:反馈业务操作
 */

public interface FeedBackService {

    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    void submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    DataMap getAllFeedback(int rows, int pageNum);

}
