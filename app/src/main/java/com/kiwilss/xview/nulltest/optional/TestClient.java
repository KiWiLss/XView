package com.kiwilss.xview.nulltest.optional;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Optional;

/**
 * @author : Lss Administrator
 * @FileName: TestClient
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class TestClient {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        System.out.println("------------");
        TestBean testBean = new TestBean();
        System.out.println(testBean.getTest());
        //System.out.println(testBean.getTestBeanOptional().getOptional());



            System.out.println("------------------");
            test(testBean);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String test(TestBean testBean){
        return Optional.ofNullable(testBean).flatMap(TestBean::getTestBeanOptionalOptional)
                .map(TestBean.TestBeanOptional::getOptional)
                .orElse("什么都没有");
    }

}

