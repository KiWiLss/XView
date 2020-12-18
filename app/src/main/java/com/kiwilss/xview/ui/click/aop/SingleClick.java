package com.kiwilss.xview.ui.click.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : Lss Administrator
 * @FileName: SingleClick
 * @e-mail : kiwilss@163.com
 * @time : 2020/12/17
 * @desc : {DESCRIPTION}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleClick {
    //点击间隔时间
    long value() default 1000;
}
