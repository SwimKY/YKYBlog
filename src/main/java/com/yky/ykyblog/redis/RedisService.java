package com.yky.ykyblog.redis;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * @Description: Redis操作
 */
public interface RedisService {

    /**
     * 判断key是否存在
     */
    Boolean hasKey(String key);


}
