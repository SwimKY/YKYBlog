package com.yky.ykyblog.model;

import lombok.Data;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 反馈
 */
@Data
public class FeedBack {


    private int id;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 反馈人
     */
    private int personId;

    /**
     * 反馈时间
     */
    private String feedbackDate;


}
