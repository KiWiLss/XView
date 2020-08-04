package com.kiwilss.xview.nulltest;

/**
 * @author : Lss Administrator
 * @FileName: TestMain
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("-----------");
        JavaNullTest javaNullTest = null;
        System.out.println(NullFactory.get(null).getName());
        javaNullTest = new JavaNullTest();
        javaNullTest.setName("kity");
        System.out.println(NullFactory.get(javaNullTest).getName());
    }
}

