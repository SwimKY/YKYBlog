package com.yky.ykyblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: TODO
 */
@Data
@NoArgsConstructor
public class LeaveMessageLikesRecord {

    private long id;

    /**
     * 文章页
     */
    private String pageName;

    /**
     * 评论的id
     */
    private int pId;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public LeaveMessageLikesRecord(String pageName, int pId, int likerId, String likeDate) {
        this.pageName = pageName;
        this.pId = pId;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }

}
