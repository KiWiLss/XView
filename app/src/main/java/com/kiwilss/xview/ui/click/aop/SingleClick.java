package com.kiwilss.xview.ui.click.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author : Lss Administrator
 * @FileName: SingleClick
 * @e-mail : kiwilss@163.com
 * @time : 2020/12/17
 * @desc : {DESCRIPTION}
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface SingleClick {
    //点击间隔时间
    long value() default 1000;
}
