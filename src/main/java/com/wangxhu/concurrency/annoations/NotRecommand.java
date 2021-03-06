package com.wangxhu.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Created on 19-1-7</p>
 *
 * @author:StormWangxhu
 * @description: <p>描述</p>
 */

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface NotRecommand {

    String value() default "";

}

