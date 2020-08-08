package com.yky.ykyblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 友链
 */
@Data
@NoArgsConstructor
public class FriendLink {

    private int id;

    /**
     * 博主
     */
    private String blogger;

    /**
     * 博主url
     */
    private String url;

    public FriendLink(String blogger, String url){
        this.blogger = blogger;
        this.url = url;
    }

}
