package com.evan.lustre.common.annotation;

import com.evan.lustre.common.enums.RoleEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName authentication
 * @Description
 * @Author EvanWang
 * @Version 1.0.0
 * @Date 2019/12/5 11:27
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {
    RoleEnum value();
}
