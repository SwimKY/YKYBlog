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
public class CommentLikesRecord {


    private long id;

    /**
     * 文章id
     */
    private long articleId;

    /**
     * 评论的id
     */
    private long pId;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public CommentLikesRecord(long articleId, int pId, int likerId, String likeDate) {
        this.articleId = articleId;
        this.pId = pId;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }

}
