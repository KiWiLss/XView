package com.kiwilss.xview.nulltest;

/**
 * @author : Lss Administrator
 * @FileName: NullFactory
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class NullFactory {
    public static IJavaNullTest get(IJavaNullTest iJavaNullTest){
        if (iJavaNullTest == null){
            return new NullJavaNullTest();
        }
        return iJavaNullTest;
    }
}

