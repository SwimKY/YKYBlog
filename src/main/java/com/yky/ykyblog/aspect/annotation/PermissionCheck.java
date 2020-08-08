package com.yky.ykyblog.aspect.annotation;

import java.lang.annotation.*;

/**
 * @Author: yky
 * @CreateTime: 2020-08-06
 * Describe:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissionCheck {
    String value();
}
