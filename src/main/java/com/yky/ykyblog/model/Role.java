package com.yky.ykyblog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: 权限
 */
@Data
@NoArgsConstructor
public class Role {

    private int id;

    private String name;

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
