package com.beauty.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/30 4:01 下午
 */
@Retention(RetentionPolicy.CLASS)
@Documented()
@Target(ElementType.TYPE)
public @interface WechatAuth {

}
